origin set @s kitsune:kitsune_subclass kitsune:kitsune_classes/overworld_kitsune
title @s actionbar [{"text": "[Overworld Mode]","color": "green","bold": true}]
execute at @s run playsound minecraft:block.anvil.land player @a[distance=..10] ~ ~ ~ 0.2 1
execute at @s run playsound minecraft:block.grass.break player @a[distance=..10] ~ ~ ~ 10 1
particle minecraft:splash ~ ~ ~ 0.3 1 0.3 0.01 250 force
resource set @s kitsune:kitsune/mode_switch_mode_resource 1
power revoke @s kitsune:kitsune/nether/fire_circle kitsune:kitsune_classes/nether_kitsune
power revoke @s kitsune:kitsune/nether/nether_portal kitsune:kitsune_classes/nether_kitsune
power revoke @s kitsune:kitsune/nether/flame_ray kitsune:kitsune_classes/nether_kitsune
power revoke @s kitsune:kitsune/nether/nether_body kitsune:kitsune_classes/nether_kitsune
power revoke @s kitsune:kitsune/nether/fire_immunity kitsune:kitsune_classes/nether_kitsune
power revoke @s kitsune:kitsune/nether/soul_mode kitsune:kitsune_classes/nether_kitsune