package com.shoestore.constants;

public final class Constants {
    public static final long ERROR_INVALID_ORDER_STATUS = -1;
    public static final long ERROR_INCONSISTENT_VERSIONS_HISTORY = -2;

    public static final long ERROR_OUT_OF_STOCK = -1;
    public static final long ERROR_INVALID_SHOE_SIZE = -2;
    public static final long ERROR_NEGATIVE_DEPOSIT_AMOUNT = -1;
    public static final long ERROR_ENTITY_NOT_FOUND = -99;

    public static final long SUCCESS = 1;
    public static final long UNKNOWN_ERROR = -999;

    public static final int INITIAL_AVAILABILITY = 0;

    public enum SizeEnum {
        SIZE34(34, "size_34"),
        SIZE35(35, "size_35"),
        SIZE36(36, "size_36"),
        SIZE37(37, "size_37"),
        SIZE38(38, "size_38"),
        SIZE39(39, "size_39"),
        SIZE40(40, "size_40"),
        SIZE41(41, "size_41"),
        SIZE42(42, "size_42"),
        SIZE43(43, "size_43"),
        SIZE44(44, "size_44"),
        SIZE45(45, "size_45"),
        SIZE46(46, "size_46");

        public final int label;
        public final String column;

        private SizeEnum(int label, String column) {
            this.label = label;
            this.column = column;
        }
    }

    private Constants() {}
}
