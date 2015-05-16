package com.elevendustries.firecracker;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class UpdateCommandGroup extends CommandGroup {

    public UpdateCommandGroup() {
        addSequential(new UpdateChannels(null));
    }
}
