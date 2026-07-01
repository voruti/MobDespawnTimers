package dev.shadowsoffire.despawntimers;

import net.minecraft.world.entity.Entity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.MobDespawnEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(MobDespawnTimers.MODID)
public class MobDespawnTimers {
  // Define mod id in a common place for everything to reference
  public static final String MODID = "despawntimers";

  // The constructor for the mod class is the first code that is run when your mod is loaded.
  // FML will recognize some parameter types like IEventBus or ModContainer and pass them in
  // automatically.
  public MobDespawnTimers(ModContainer modContainer) {
    // Register ourselves for server and other game events we are interested in.
    // Note that this is necessary if and only if we want *this* class (MobDespawnTimers) to respond
    // directly to events.
    // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like
    // onServerStarting() below.
    NeoForge.EVENT_BUS.register(this);

    // Register our mod's ModConfigSpec so that FML can create and load the config file for us
    modContainer.registerConfig(ModConfig.Type.SERVER, Config.SPEC);
  }

  // You can use SubscribeEvent and let the Event Bus discover methods to call
  @SubscribeEvent
  public void onDespawn(MobDespawnEvent event) {
    Entity ent = event.getEntity();
    if (Config.despawnDelay >= ent.tickCount) {
      event.setResult(MobDespawnEvent.Result.DENY);
    }
  }
}
