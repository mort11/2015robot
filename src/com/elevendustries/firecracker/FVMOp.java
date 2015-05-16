package com.elevendustries.firecracker;

public enum FVMOp {

    FVM_NOP_OPCODE(0), FVM_PUSH_OPCODE(1), FVM_POP_OPCODE(2), FVM_WRITE_OPCODE(
            3), FVM_DELAY_OPCODE(4), FVM_INC_OPCODE(5), FVM_DEC_OPCODE(6), FVM_ADD_OPCODE(
            7), FVM_SUB_OPCODE(8), FVM_CMP_OPCODE(9), FVM_OR_OPCODE(10), FVM_AND_OPCODE(
            11), FVM_TEST_OPCODE(12), FVM_NOT_OPCODE(13), FVM_SWAP_OPCODE(4), FVM_DUP_OPCODE(
            15), FVM_IF_OPCODE(16), FVM_JMP_OPCODE(17), FVM_JMPR_OPCODE(18), FVM_DEFMC_OPCODE(
            19), FVM_CALMC_OPCODE(20), FVM_RETMC_OPCODE(21), FVM_SAVMC_OPCODE(
            22), FVM_DELMC_OPCODE(23), FVM_LDMC_OPCODE(24), FVM_WAITS_OPCODE(25), FVM_POSTS_OPCODE(
            26), FVM_KILLW_OPCODE(27);
    private final int val;

    private FVMOp(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

}
