package com.marctron.slimalizer.setup;

import com.marctron.slimalizer.Main;
import com.marctron.slimalizer.objects.items.SlimalyzerItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {

    public static void init(FMLClientSetupEvent event) {
        setup(event);


    }

    private static void setup(final FMLClientSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            ItemProperties.register(Registration.SLIMALIZER.get(),
                    new ResourceLocation(Main.MODID, "on"), (stack, level, living, id) -> {
                        return living != null && SlimalyzerItem.isOn ? 1.0F : 0.0F;
                    });
        });
    }
}
