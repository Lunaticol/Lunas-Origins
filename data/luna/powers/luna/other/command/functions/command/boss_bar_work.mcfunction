execute at @s run bossbar set command players @a[distance=..128]
execute store result bossbar command max run attribute @s generic.max_health get
execute store result bossbar command value run data get entity @s Health
execute unless entity @s run bossbar remove command