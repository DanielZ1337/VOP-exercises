public interface LaundryConstants {

    // Machine Models:
    String WACH_6 = "6 Kg Wash";
    String WACH_12 = "12 Kg Wash";
    String TUMBLE = "Tumbler";

    // Tumbledryer price per minute:
    double TUMBLE_PRICE = 1.25;

    // Wash programs 
    String WASH_PROGRAM_1 = "95 Normal";
    String WASH_PROGRAM_2 = "60 Normal";
    String WASH_PROGRAM_3 = "40 Normal";
    String WASH_PROGRAM_4 = "30 Mild";
    String WASH_PROGRAM_5 = "40 Non-iron";
    String WASH_PROGRAM_6 = "60 Non-iron";
    String WASH_PROGRAM_7 = "Wool";

    // Wash prices (6 kg):
    double WASH_PRICE_1 = 42.00;
    double WASH_PRICE_2 = 37.50;
    double WASH_PRICE_3 = 33.50;
    double WASH_PRICE_4 = 30.00;
    double WASH_PRICE_5 = 35.00;
    double WASH_PRICE_6 = 39.50;
    double WASH_PRICE_7 = 28.00;

    // Wash prices (12 kg) just 50% over the prices for 6 kg machines 
    double FACTOR_12 = 1.5;

    // Array of Wash programs. Can be used from javaFX
    String[] PROGS =
            {
                    WASH_PROGRAM_1,
                    WASH_PROGRAM_2,
                    WASH_PROGRAM_3,
                    WASH_PROGRAM_4,
                    WASH_PROGRAM_5,
                    WASH_PROGRAM_6,
                    WASH_PROGRAM_7,
            };

}
