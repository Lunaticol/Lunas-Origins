title @a title {"text":"Reloading in 5...","color":"#83B591","bold":true}
tellraw @a [{"text":"<Chain> "},{"text":"Initiating reload sequence.","color":"#83B591","bold":true}]
schedule function luna:admin/reload/4 1s
schedule function luna:admin/reload/3 2s
schedule function luna:admin/reload/2 3s
schedule function luna:admin/reload/1 4s
schedule function luna:admin/reload/reload_warning 5s