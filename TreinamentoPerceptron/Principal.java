package TreinamentoPerceptron;

public class Principal {
    public static void main(String[] args) {
        Perceptron perceptron = new Perceptron();
        perceptron.treinar();

        System.out.println("Treinamento conclu�do em " + perceptron.getCount() + " �pocas.");
    }
}
