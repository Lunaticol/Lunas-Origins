origin set @s luna:luna_layers kitsune:kitsune_classes/nether_kitsune
title @s actionbar [{"text": "[Nether Mode]","color": "red","bold": true}]
execute at @s run playsound minecraft:block.anvil.land player @a[distance=..10] ~ ~ ~ 0.2 1
execute at @s run playsound minecraft:entity.blaze.ambient player @a[distance=..10] ~ ~ ~ 1 0
particle minecraft:lava ~ ~ ~ 0 1 0 0 50 force
resource set @s kitsune:kitsune/mode_switch_mode_resource 0
power revoke @s kitsune:kitsune/end/ender_body kitsune:kitsune_classes/ender_kitsune
power revoke @s kitsune:kitsune/end/trickery kitsune:kitsune_classes/ender_kitsune
power revoke @s kitsune:kitsune/end/teleport kitsune:kitsune_classes/ender_kitsune