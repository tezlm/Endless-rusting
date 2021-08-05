package rusting.ui.dialog.research;

import arc.Core;
import arc.math.Mathf;
import arc.scene.style.TextureRegionDrawable;
import arc.scene.ui.Image;
import arc.scene.ui.layout.Table;
import arc.util.Scaling;
import mindustry.Vars;
import mindustry.ctype.UnlockableContent;
import mindustry.gen.Sounds;
import mindustry.type.ItemStack;
import mindustry.ui.Cicon;
import mindustry.world.Tile;
import mindustry.world.blocks.storage.CoreBlock.CoreBuild;
import rusting.Varsr;
import rusting.interfaces.ResearchCenterc;
import rusting.interfaces.ResearchableObject;
import rusting.ui.dialog.CustomBaseDialog;
import rusting.world.blocks.pulse.PulseBlock;
import rusting.world.blocks.pulse.utility.PulseResearchBlock.PulseResearchBuild;

import static mindustry.Vars.player;

public class UnlockDialog extends CustomBaseDialog {

    public TextureRegionDrawable unlockIcon = new TextureRegionDrawable();
    public Image unlockImage = new Image();

    public UnlockDialog() {
        super(Core.bundle.get("erui.unlockpage"), Core.scene.getStyle(DialogStyle.class));
    }

    public void show(UnlockableContent content){

        clear();
        addCloseButton();
        Tile tile = PulseBlock.getCenterTeam(player.team()).tile;

        cont.margin(30);
        unlockIcon.set(content.icon(Cicon.tiny));
        unlockImage = new Image(unlockIcon).setScaling(Scaling.fit);
        ItemStack[] rCost = ((PulseBlock) content).researchModule.centerResearchRequirements;
        Table itemsCost = new Table();

        itemsCost.table(table -> {

            //used for columns.
            int count = 1;
            int cols = Mathf.clamp((Core.graphics.getWidth() - 30) / (32 + 10), 1, 8);

            for(ItemStack costing: rCost) {
                Image itemImage = new Image(new TextureRegionDrawable().set(costing.item.icon(Cicon.medium))).setScaling(Scaling.fit);

                table.stack(
                    itemImage,
                    new Table(t -> {
                        t.add(Math.min(tile.build.team.core().items.get(costing.item), costing.amount) + "/" + costing.amount);
                    }).left().margin(1, 3, 2, 0)
                ).pad(10f);
                if((count++) % cols == 0) table.row();
            }
        });
        pane(table -> {
            table.center();
            table.button("Unlock?", () -> {
                if(tile.build instanceof ResearchCenterc && content instanceof ResearchableObject){
                    PulseResearchBuild building = (PulseResearchBuild) tile.build;
                    CoreBuild coreBlock = building.team.core();
                    boolean canResearch = false;
                    if(Vars.state.rules.infiniteResources || coreBlock.items.has(rCost, 1)){
                        for(int i = 0; i < ((ResearchableObject) content).researchModule.centerResearchRequirements.length; i++){
                            coreBlock.items.remove(((ResearchableObject) content).researchModule.centerResearchRequirements[i]);
                        }
                        building.configure(content.name);
                        Sounds.unlock.at(player.x, player.y);
                    }
                }
                Varsr.ui.blocklist.refresh(tile);
                hide();
            }).height(75f).width(145);
            table.add(unlockImage).size(8 * 12);
            table.row();
            table.add(itemsCost);
        });

        super.show();
    }
}
