package hw_2.bai1;

public class Fraction {
    private float numerator;
    private float denominator;
    public Fraction(){}

    public Fraction(float numerator, float denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public float getNumerator() {
        return numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    public void setNumerator(float numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(float denominator) {
        this.denominator = denominator;
    }


    public Fraction add(Fraction c){
        if(this.getDenominator() == c.getDenominator()){
            this.numerator += c.getNumerator();
        }else {
            int boi = 1;
            float bcnn = 0;
            while (true){
                if (boi * Math.max(this.denominator, c.denominator) % Math.min(this.denominator, c.getDenominator()) == 0){
                    bcnn = boi * Math.max(this.denominator, c.getDenominator());
                    break;
                }else {
                    boi++;
                }
                this.numerator = this.denominator*(bcnn/this.denominator) + c.getNumerator()*(bcnn/ c.getDenominator());
                this.denominator = bcnn;
            }
        }
        return normalize(this);
    }
    public Fraction minus(Fraction c){
        if(this.getDenominator() == c.getDenominator()){
            this.numerator -= c.getNumerator();
        }else {
            int boi = 1;
            float bcnn = 0;
            while (true){
                if (boi * Math.max(this.denominator, c.denominator) % Math.min(this.denominator, c.getDenominator()) == 0){
                    bcnn = boi * Math.max(this.denominator, c.getDenominator());
                    break;
                }else {
                    boi++;
                }
                this.numerator = this.denominator*(bcnn/this.denominator) - c.getNumerator()*(bcnn/ c.getDenominator());
                this.denominator = bcnn;
            }
        }
        return normalize(this);
    }


    public Fraction muti(Fraction c){
        this.numerator *= c.getNumerator();
        this.denominator *= c.getDenominator();
        return normalize(this);
    }
    public Fraction divi(Fraction c){
        this.numerator *= c.getDenominator();
        this.denominator *= c.getNumerator();

        return normalize(this);
    }
    public Fraction normalize(Fraction c){
        float ucln = 0;
        if (c.getNumerator() == 0){
            return c;
        }
        for(int i = (int) Math.min(Math.abs(c.getDenominator()), Math.abs(c.getNumerator())); i > 0; i--){
            if(c.getDenominator() % i == 0 && c.getNumerator() % i == 0){
                ucln = i;
                break;
            }
        }

        return new Fraction(c.getNumerator()/ ucln, c.getDenominator()/ ucln);
    }

    @Override
    public String toString() {
        if(this.getNumerator()*this.getDenominator() < 0 && this.getDenominator() < 0){
            return "Fraction{" +
                    "numerator=" + (-1)*numerator +
                    ", denominator=" + (-1)*denominator +
                    '}';
        }else if(this.numerator == 0){
            return "Fraction= " + 0;
        }
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
