package frise.project.mordapp.retrofit;

public interface ResultListener<T> {

    void finish(T container);
    void error(String message);

}
