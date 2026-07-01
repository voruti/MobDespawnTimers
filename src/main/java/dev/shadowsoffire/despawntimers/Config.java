package dev.shadowsoffire.despawntimers;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
  private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

  static final ModConfigSpec SPEC = BUILDER.build();

  private static final ModConfigSpec.LongValue DESPAWN_DELAY =
      BUILDER
          .comment("The time, in ticks, that a mob may not despawn for after spawning.")
          .defineInRange("despawn_delay", 600L, 0L, Long.MAX_VALUE);

  public static long despawnDelay;
}
