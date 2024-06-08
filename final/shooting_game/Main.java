public class Main {
    public static void main(String[] args) {
        ComplexNumber x = ComplexNumber.create(2.0, 1.0);
        ComplexNumber y = ComplexNumber.create(5.0, -3.0);
        System.out.println(x.abs());
        System.out.println(y.abs());
        x.add(y).print();
        x.mul(y).print();
    }
}

interface ComplexNumber {
    static ComplexNumber create(double real0, double imag0) {
        return new ComplexNumberImpl(real0, imag0);
    }

    double getReal();

    double getImag();

    double abs();

    ComplexNumber add(ComplexNumber y);

    ComplexNumber mul(ComplexNumber y);

    void print();
}

class ComplexNumberImpl implements ComplexNumber {
    private double real, imag;

    ComplexNumberImpl(double real0, double imag0) {
        real = real0;
        imag = imag0;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public double abs() {
        return Math.sqrt(real * real + imag * imag);
    }

    public ComplexNumber add(ComplexNumber y) {
        return new ComplexNumberImpl(real + y.getReal(), imag + y.getImag());
    }

    public ComplexNumber mul(ComplexNumber y) {
        double newReal = real * y.getReal() - imag * y.getImag();
        double newImag = real * y.getImag() + imag * y.getReal();
        return new ComplexNumberImpl(newReal, newImag);
    }

    public void print() {
        System.out.println(real + " + (" + imag + ")i");
    }
}
