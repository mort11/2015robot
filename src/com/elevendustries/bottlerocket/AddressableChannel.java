package com.elevendustries.bottlerocket;

import com.elevendustries.firecracker.FVMChannel;
import com.elevendustries.firecracker.FVMCommand;
import com.elevendustries.firecracker.Firecracker;

public class AddressableChannel extends FVMChannel {

    private TricolorLED[] leds;

    public AddressableChannel(Firecracker owner, ColorType type, int length) {
        super(owner);
        ColorType type1 = type;
        int length1 = length;
        this.leds = new TricolorLED[length];
        for (int i = 0; i < leds.length; i++) {
            leds[i] = new TricolorLED(type1);
        }
    }


    public TricolorLED getLED(int index) {
        return leds[index];
    }


    @Override
    public FVMCommand update() {
        // TODO Auto-generated method stub
        return null;
    }

}
