package error.example.domain;

import error.example.domain.error.AnotherDomainError;
import error.example.domain.error.DomainError;
import error.example.domain.error.SomeDomainError;
import error.example.domain.exception.AnotherDomainException;
import error.example.domain.exception.SomeDomainException;
import error.example.domain.runtimeexception.AnotherDomainRuntimeException;
import error.example.domain.runtimeexception.SomeDomainRuntimeException;
import io.vavr.control.Either;

import java.util.Random;

public class Entity {

    /**
     * Method with Unchecked Exception
     *
     * @return Result
     * @throws SomeDomainRuntimeException    Some
     * @throws AnotherDomainRuntimeException Another
     */
    public String methodWithUncheckedException() {
        if (isError()) {
            if (isTrue()) {
                throw new SomeDomainRuntimeException("Some domain runtime exception");
            } else {
                throw new AnotherDomainRuntimeException("Another domain runtime exception");
            }
        }

        return "Success";
    }

    /**
     * Method with Checked Exception
     *
     * @return Result
     */
    public String methodWithCheckedException() throws SomeDomainException, AnotherDomainException {
        if (isError()) {
            if (isTrue()) {
                throw new SomeDomainException("Some domain exception");
            } else {
                throw new AnotherDomainException("Another domain exception");
            }
        }

        return "Success";
    }

    /**
     * Method with Either
     *
     * @return Either lefts:
     * {@link SomeDomainError} Some
     * {@link AnotherDomainError} Another
     */
    public Either<DomainError, String> methodWithEither() {
        if (isError()) {
            if (isTrue()) {
                return Either.left(new SomeDomainError("Some domain error"));
            } else {
                return Either.left(new AnotherDomainError("Another domain error"));
            }
        }

        return Either.right("Success");
    }

    private boolean isError() {
        return isTrue();
    }

    private boolean isTrue() {
        return new Random().nextBoolean();
    }

}
