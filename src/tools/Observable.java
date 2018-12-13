package tools;

public interface Observable {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(Object arg);
}
