particle minecraft:sculk_charge 0.0 ~ ~1 ~ .5 1 .5 0.0001 100 force
playsound minecraft:block.sculk.step master @s ~ ~ ~ 1 .1
origin set @s global:infection global:infected
origin set @s global:infections global:infections/sculk_infection