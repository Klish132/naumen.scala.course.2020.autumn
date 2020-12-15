
trait Monad[F[_]] {

    def pure[A](a: A): F[A]

    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]

    def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] = {
        flatMap(fa)(x => flatMap(fb)(y => pure(f(x, y))))
    }

    def sequence[A](fas: List[F[A]]): F[List[A]] = {
        var sequences = List[A]()
        val result = fas.map(x => flatMap(x)(y => {
            sequences :+= y
            pure(sequences)
        }))
        result.last
    }

    def compose[A, B, C](f: A => F[B])(g: B => F[C]): A => F[C] = {
        x => flatMap(f(x))(y => g(y))
    }
}

trait Functor[F[_]] {
    def map[A, B](a: F[A])(f: A => B): F[B]
}

object Functor {
    def functorFromMonad[F[_]](M: Monad[F]): Functor[F] = new Functor[F] {
        def map[A, B](a: F[A])(f: A => B): F[B] = M.flatMap(a)(x => M.pure(f(x)))
    }
}
