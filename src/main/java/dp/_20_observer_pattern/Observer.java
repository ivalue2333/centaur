package dp._20_observer_pattern;

public abstract class Observer {
   protected Subject subject;
   public abstract void update();
}