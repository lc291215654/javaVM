package Interpreter;

/**
 * Created by LICHENG on 2017/12/17.
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data){
        this.data = data;
    }

    public boolean interpret(String context) {
        if(context.contains(data)){
            return true;
        }
        return false;
    }
}