package error.example.application;

import error.example.domain.Entity;
import error.example.domain.error.AnotherDomainError;
import error.example.domain.error.DomainError;
import error.example.domain.error.SomeDomainError;
import error.example.domain.exception.AnotherDomainException;
import error.example.domain.exception.SomeDomainException;
import io.vavr.control.Either;

public class ApplicationService {

    /**
     * Method with unchecked exception
     *
     * @return Result
     * @throws SomeDomainException    Some
     * @throws AnotherDomainException Another
     */
    public String methodWithUncheckedException() {
        var entity = new Entity();
        return entity.methodWithUncheckedException();
    }

    /**
     * Method with checked exception
     *
     * @return Result
     */
    public String methodWithCheckedException() throws AnotherDomainException, SomeDomainException {
        var entity = new Entity();
        return entity.methodWithCheckedException();
    }

    /**
     * Method with Either
     *
     * @return Either lefts:
     * {@link SomeDomainError} Some
     * {@link AnotherDomainError} Another
     */
    public Either<DomainError, String> methodWithEither() {
        var entity = new Entity();
        return entity.methodWithEither();
    }

}
