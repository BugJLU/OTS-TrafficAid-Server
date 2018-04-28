package org.bugjlu.ots_server.assistService;

public class IntimacyService {
    /**
     * 0    relative
     * 1    friend
     * 2    colleague
     * 3    stranger
     */
    public static double[] intimacies = {0.85, 0.75, 0.70, 0.50};
    public static double get1JumpIntimacy(Integer type) {
        if (type == null) return 0;
        if (type < 0 || type > 3) return 0;
        return intimacies[type];
    }
    public static double calculate2JumpIntimacy(Integer jump1type, Integer jump2type){
        if (jump1type == null || jump2type == null) return 0;
        double imc1 = intimacies[jump1type];
        double imc2 = intimacies[jump2type];
        double res = imc1 * (imc2 - 0.04);
        return res;
    }
}
