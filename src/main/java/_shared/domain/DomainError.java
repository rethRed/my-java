package _shared.domain;

public abstract class DomainError extends Exception {
    
    private String _name;

    public DomainError(String message) {
        super(message);
        this._name = this.getClass().getSimpleName();
    }

    public DomainError() {
        super();
        this._name = this.getClass().getSimpleName();
    }


    public String getErrorName() {
        return this._name;
    }
}
