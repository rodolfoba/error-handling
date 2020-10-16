package error.example;

import error.example.ui.View;

public class Main {

    public static void main(String[] args) {
        var view = new View();
        view.someMethodWithUncheckedException();
        view.someMethodWithCheckedException();
        view.someMethodWithEither();
    }

}
