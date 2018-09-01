public class Perceptron {

    private float[] weights;
    private float[][] input;
    private float[] output;
    private int numberOfWeights;


    public Perceptron(float[][] input, float[] output) {
        this.input = input;
        this.output = output;
        this.numberOfWeights = this.input[0].length;
        this.weights = new float[numberOfWeights];
        initializeWeights();
        
    }

    private void initializeWeights() {
        for (int i = 0; i < numberOfWeights; i++) {
            weights[i] = 0;
        }
    }

    public void train(float learningRate) {
        float totalError = 1;
        while (totalError != 0) {
            totalError = 0;
            for (int i = 0; i < output.length; i++) {
                float calcOutput = calcOutput(input[i]);
                float error = Math.abs(output[i] - calcOutput);
                totalError+=error;
                for (int j = 0; j < numberOfWeights; j++) {
                    weights[j] = weights[j] + learningRate * input[i][j] * error;
                }
            }
            System.out.println("Training error is " + totalError);

        }
    }

    public float calcOutput(float[] input) {
        float sum = 0f;
        for (int i = 0; i < input.length; i++) {
            sum = sum+weights[i] * input[i];
        }
        return ActivationFunction.stepFunction(sum);
    }


}
