power remove @s artificer:artificer/artificer_stun
power grant @s scorch:thermal_shield
execute at @s run playsound minecraft:entity.blaze.ambient player @a[distance=..10] ~ ~ ~ 1 0
particle minecraft:lava ~ ~ ~ 0 1 0 0 50 force
resource set @s command:warrior/switcher_mode_resource 2