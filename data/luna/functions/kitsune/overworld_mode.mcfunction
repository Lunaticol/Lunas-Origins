origin set @s luna:luna_layers luna:kitsune_classes/overworld_kitsune
title @s actionbar [{"text": "[Overworld Mode]","color": "green","bold": true}]
execute at @s run playsound minecraft:block.anvil.land player @a[distance=..10] ~ ~ ~ 0.2 1
execute at @s run playsound minecraft:block.grass.break player @a[distance=..10] ~ ~ ~ 10 1
particle minecraft:splash ~ ~ ~ 0.3 1 0.3 0.01 250 force
resource set @s luna:kitsune/mode_switch_mode_resource 1
power revoke @s luna:kitsune/nether/fire_circle luna:kitsune_classes/nether_kitsune
power revoke @s luna:kitsune/nether/nether_portal luna:kitsune_classes/nether_kitsune
power revoke @s luna:kitsune/nether/flame_ray luna:kitsune_classes/nether_kitsune
power revoke @s luna:kitsune/nether/nether_body luna:kitsune_classes/nether_kitsune
power revoke @s luna:kitsune/nether/fire_immunity luna:kitsune_classes/nether_kitsune
power revoke @s luna:kitsune/nether/soul_mode luna:kitsune_classes/nether_kitsune