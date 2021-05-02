package guru.springframework;

/**
 * Created by jt on 10/10/18.
 */
class Sum implements Expression {
    final Expression augend;
    final Expression addend;

    public Sum(Expression augmend, Expression addmend) {
        this.augend = augmend;
        this.addend = addmend;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, this.addend);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }
}
