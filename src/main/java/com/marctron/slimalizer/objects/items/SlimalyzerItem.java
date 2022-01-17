package com.marctron.slimalizer.objects.items;

import com.marctron.slimalizer.setup.Registration;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.WorldgenRandom;

public class SlimalyzerItem extends Item {


    public boolean isInSlimeChunk;
    public static boolean isOn;

    int timer;

    public SlimalyzerItem(Properties properties) {
        super(properties);
        properties.stacksTo(1);
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int p_41407_, boolean p_41408_) {
        timer++;
        if (!level.isClientSide()) {
            ChunkPos chunkpos = new ChunkPos(entity.blockPosition());

            if (WorldgenRandom.seedSlimeChunk(chunkpos.x, chunkpos.z, ((WorldGenLevel)level).getSeed(), 987234911L).nextInt(10) == 0) {
                isInSlimeChunk=true;
                //System.out.println("SlimeChunk");
            } else {
                isInSlimeChunk=false;
                //System.out.println("NOT SlimeChunk");
            }
        }
       //System.out.println(timer);

        if (timer>=5){
            if ((isInSlimeChunk)) {
                isOn=true;
                level.playSound((Player) entity, entity.position().x, entity.position().y, entity.position().z, Registration.ITEM_SLIMALYZER_PING.get(), SoundSource.PLAYERS, 1F, 0.9F);

            }else
            {isOn=false;}
            timer=0;
        }
    }
}