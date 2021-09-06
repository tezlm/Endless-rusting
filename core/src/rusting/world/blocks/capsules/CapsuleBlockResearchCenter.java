package rusting.world.blocks.capsules;

import arc.scene.ui.layout.Table;
import arc.struct.Seq;
import mindustry.Vars;
import mindustry.gen.Building;
import mindustry.gen.Icon;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.meta.BlockGroup;
import rusting.Varsr;
import rusting.content.RustingResearchTypes;
import rusting.ctype.ResearchType;
import rusting.interfaces.ResearchCenter;

public class CapsuleBlockResearchCenter extends Block implements ResearchCenter {

    public Seq<ResearchType> researchTypes = Seq.with();

    public CapsuleBlockResearchCenter(String name) {
        super(name);
        update = true;
        solid = true;
        hasPower = false;
        configurable = true;
        group = BlockGroup.power;
        researchTypes.add(RustingResearchTypes.capsule);
    }

    @Override
    public Seq<ResearchType> researchTypes() {
        return researchTypes;
    }

    public void buildDialog(Tile tile){
        Vars.control.input.frag.config.hideConfig();
        if(!(tile.build instanceof CapsuleBlockResearchCenterBuild)) return;
        Varsr.ui.blocklist.show(tile);
    }

    public class CapsuleBlockResearchCenterBuild extends Building {

        public void buildConfiguration(Table table){
            super.buildConfiguration(table);
            table.button(Icon.pencil, () -> {
                buildDialog(tile);
            }).size(40f);
        }

    }

}
