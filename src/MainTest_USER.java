import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;


public class MainTest_USER {

    public static void main(String[] arg) throws IOException {
        // Example   BIBLE_sequence_utility   BMS_sequence_utility   FIFA_sequence_utility
        // kosarak10k_sequence_utility   SIGN_sequence_utility

        String input= "src/dataset/test.txt";

        String output = ".//output.txt";


        double minSup = 0.1;
        double maxSup = 1;
        double minUtil = 30;
        double minConfidence = 0.5;
        double minOutlier = 0.9;
        int maxAntecedentSize =10;
        int maxConsequentSize = 10;
        int maximumNumberOfSequences = 10000;


        // Applying the USER algorithm

        // USER
        //AlgoUSER algoUSER = new AlgoUSER();

        // +ROOR pruning strategy
        //AlgoUSER_1 algoUSER=new AlgoUSER_1();

        // +REIO-I pruning strategy
        AlgoUSER_12 algoUSER=new AlgoUSER_12();

        // +REIO-II pruning strategy
        //AlgoUSER_123 algoUSER=new AlgoUSER_123();

        // +LEIO pruning strategy
        //AlgoUSER_1234 algoUSER = new AlgoUSER_1234();

        algoUSER.runAlgorithm(input, output, minConfidence, minUtil, maxAntecedentSize,
                maxConsequentSize, maximumNumberOfSequences);
        algoUSER.printStats(input);
    }

    public static String fileToPath(String filename) throws UnsupportedEncodingException {
        URL url = MainTest_USER.class.getResource(filename);
        return java.net.URLDecoder.decode(url.getPath(), "UTF-8");
    }
}

