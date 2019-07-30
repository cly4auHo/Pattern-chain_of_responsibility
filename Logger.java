package chain_of_lvl_responsibility;

public abstract class Logger {

    int priority;
    Logger next;

    abstract void write(String message);

    public final void writeMessage(String message, int level) {
        if (level <= priority) {
            write(message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    public Logger(int priority) {
        this.priority = priority;
    }
}

class SMSLogger extends Logger {

    public SMSLogger(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("SMS: " + message);
    }
}

class FileLogger extends Logger {

    public FileLogger(int priority) {
        super(priority);
    }

    @Override
    void write(String message) {
        System.out.println("Write in File: " + message);
    }
}

class EmailLogger extends Logger {

    public EmailLogger(int priority) {
        super(priority);
    }

    @Override
    void write(String message) {
        System.out.println("Message on e-mail: " + message);
    }
}
