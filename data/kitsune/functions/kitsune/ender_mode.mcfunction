origin set @s kitsune:kitsune_subclass kitsune:kitsune_classes/ender_kitsune
title @s actionbar [{"text": "[Ender Mode]","color": "dark_aqua","bold": true}]
execute at @s run playsound minecraft:block.anvil.land player @a[distance=..10] ~ ~ ~ 0.2 1
execute at @s run playsound minecraft:entity.enderman.teleport player @a[distance=..10] ~ ~ ~ 1 0
particle minecraft:dragon_breath ~ ~ ~ 0.3 1 0.3 0.01 250 force
resource set @s kitsune:kitsune/mode_switch_mode_resource 2
power revoke @s kitsune:kitsune/overworld/passive_mobs kitsune:kitsune_classes/overworld_kitsune
power revoke @s kitsune:kitsune/overworld/overworld kitsune:kitsune_classes/overworld_kitsune
power revoke @s kitsune:kitsune/overworld/healing kitsune:kitsune_classes/overworld_kitsune