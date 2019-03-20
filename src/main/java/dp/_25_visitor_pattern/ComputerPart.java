package dp._25_visitor_pattern;

public interface ComputerPart {
   public void accept(ComputerPartVisitor computerPartVisitor);
}