package dev.shadowsoffire.despawntimers;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = MobDespawnTimers.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
  private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

  private static final ModConfigSpec.LongValue DESPAWN_DELAY = BUILDER.comment("The time, in ticks, that a mob may not despawn for after spawning.").defineInRange("despawn_delay", 600L, 0L, Long.MAX_VALUE);

  static final ModConfigSpec SPEC = BUILDER.build();

  public static long despawnDelay;

  @SubscribeEvent
  static void onLoad(final ModConfigEvent event) {
    despawnDelay = DESPAWN_DELAY.get();
  }
}
