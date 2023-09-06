package TreinamentoPerceptron;

public class Perceptron {

    private double[] w = new double[3];
    private double NET = 0;
    private final int epocasMax = 30;
    private int count = 0;
    private int[][] matrizAprendizado = new int[4][3];

    public int getCount() {
        return this.count;
    }

    public Perceptron() {
        // Inicializa a matriz de aprendizado
        this.matrizAprendizado[0][0] = 0;
        this.matrizAprendizado[0][1] = 0;
        this.matrizAprendizado[0][2] = 0;

        this.matrizAprendizado[1][0] = 0;
        this.matrizAprendizado[1][1] = 1;
        this.matrizAprendizado[1][2] = 0;

        this.matrizAprendizado[2][0] = 1;
        this.matrizAprendizado[2][1] = 0;
        this.matrizAprendizado[2][2] = 0;

        this.matrizAprendizado[3][0] = 1;
        this.matrizAprendizado[3][1] = 1;
        this.matrizAprendizado[3][2] = 1;

        // Inicializa os pesos sinápticos
        w[0] = 0;
        w[1] = 0;
        w[2] = 0;
    }

    public int executar(int x1, int x2) {
        NET = (x1 * w[0]) + (x2 * w[1]) + ((-1) * w[2]);
        if (NET >= 0) {
            return 1;
        }
        return 0;
    }

    public void treinar() {
        boolean treinou = true;
        int saida;

        for (int i = 0; i < matrizAprendizado.length; i++) {
            saida = executar(matrizAprendizado[i][0], matrizAprendizado[i][1]);
            
            System.out.println("Índice da linha: " + i);
            System.out.println("Saída: " + saida);
            System.out.println("Valor esperado: " + matrizAprendizado[i][2]);

            if (saida != matrizAprendizado[i][2]) {
                corrigirPeso(i, saida);
                treinou = false;
            }
        }
        
        this.count++;

        if ((treinou == false) && (this.count < this.epocasMax)) {
            System.out.println("Treinamos " + count + " vezes");
            treinar();
        }
    }

    public void corrigirPeso(int i, int saida) {
        w[0] = w[0] + (1 * (matrizAprendizado[i][2] - saida) * matrizAprendizado[i][0]);
        w[1] = w[1] + (1 * (matrizAprendizado[i][2] - saida) * matrizAprendizado[i][1]);
        w[2] = w[2] + (1 * (matrizAprendizado[i][2] - saida) * (-1));

        System.out.println("Peso primeira entrada (w0): " + w[0]);
        System.out.println("Peso segunda entrada (w1): " + w[1]);
        System.out.println("Peso para o Bias (w2): " + w[2]);
    }
}
