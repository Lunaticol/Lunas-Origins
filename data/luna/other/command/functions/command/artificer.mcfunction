power grant @s artificer:artificer/artificer_stun
particle minecraft:explosion ~ ~ ~ 1 1 1 1 20 force
playsound minecraft:entity.generic.explode player @a[distance=..10] ~ ~ ~ 1 1
resource set @s command:warrior/switcher_mode_resource 1