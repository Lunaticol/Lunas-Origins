origin set @s luna:luna_layers luna:kitsune_classes/ender_kitsune
title @s actionbar [{"text": "[Ender Mode]","color": "dark_aqua","bold": true}]
execute at @s run playsound minecraft:block.anvil.land player @a[distance=..10] ~ ~ ~ 0.2 1
execute at @s run playsound minecraft:entity.enderman.teleport player @a[distance=..10] ~ ~ ~ 1 0
particle minecraft:dragon_breath ~ ~ ~ 0.3 1 0.3 0.01 250 force
resource set @s luna:kitsune/mode_switch_mode_resource 2
power revoke @s luna:kitsune/overworld/passive_mobs luna:kitsune_classes/overworld_kitsune
power revoke @s luna:kitsune/overworld/overworld luna:kitsune_classes/overworld_kitsune
power revoke @s luna:kitsune/overworld/healing luna:kitsune_classes/overworld_kitsune
advancement grant @s only luna:kitsune/ender/ender