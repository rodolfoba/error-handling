package error.example.ui;

import error.example.application.ApplicationService;
import error.example.domain.error.AnotherDomainError;
import error.example.domain.error.SomeDomainError;
import error.example.domain.exception.AnotherDomainException;
import error.example.domain.exception.SomeDomainException;
import error.example.domain.runtimeexception.AnotherDomainRuntimeException;
import error.example.domain.runtimeexception.SomeDomainRuntimeException;

import java.util.logging.Logger;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.API.run;
import static io.vavr.Predicates.instanceOf;

/**
 * Success = Log level INFO
 * SomeDomain Exception/Error = Log level WARNING
 * AnotherDomain Exception/Error = Log level SEVERE
 */
public class View {

    private static final Logger logger = Logger.getLogger(View.class.getName());

    public void someMethodWithUncheckedException() {
        var applicationService = new ApplicationService();
        try {
            var result = applicationService.methodWithUncheckedException();
            logger.info(result);
        } catch (SomeDomainRuntimeException e) {
            logger.warning(e.getMessage());
        } catch (AnotherDomainRuntimeException e) {
            logger.severe(e.getMessage());
        }
    }

    public void someMethodWithCheckedException() {
        var applicationService = new ApplicationService();
        try {
            var result = applicationService.methodWithCheckedException();
            logger.info(result);
        } catch (SomeDomainException e) {
            logger.warning(e.getMessage());
        } catch (AnotherDomainException e) {
            logger.severe(e.getMessage());
        }
    }

    public void someMethodWithEither() {
        var applicationService = new ApplicationService();
        var either = applicationService.methodWithEither();
        either.peek(logger::info)
                .orElseRun(e -> Match(e).of(
                        Case($(instanceOf(SomeDomainError.class)), t -> run(() -> logger.warning(t.getMessage()))),
                        Case($(instanceOf(AnotherDomainError.class)), t -> run(() -> logger.severe(t.getMessage())))
                ));
    }

}
