origin set @s luna:luna_layers luna:kitsune_classes/nether_kitsune
title @s actionbar [{"text": "[Nether Mode]","color": "red","bold": true}]
execute at @s run playsound minecraft:block.anvil.land player @a[distance=..10] ~ ~ ~ 0.2 1
execute at @s run playsound minecraft:entity.blaze.ambient player @a[distance=..10] ~ ~ ~ 1 0
particle minecraft:lava ~ ~ ~ 0 1 0 0 50 force
resource set @s luna:kitsune/mode_switch_mode_resource 0
power revoke @s luna:kitsune/end/ender_body luna:kitsune_classes/ender_kitsune
power revoke @s luna:kitsune/end/trickery luna:kitsune_classes/ender_kitsune
power revoke @s luna:kitsune/end/teleport luna:kitsune_classes/ender_kitsune
advancement grant @s only luna:kitsune/nether/nether