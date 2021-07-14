package rusting.content;

import arc.graphics.Color;
import arc.struct.EnumSet;
import arc.struct.Seq;
import mindustry.content.*;
import mindustry.ctype.ContentList;
import mindustry.entities.Effect;
import mindustry.gen.Sounds;
import mindustry.graphics.CacheLayer;
import mindustry.graphics.Pal;
import mindustry.type.*;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.distribution.Conveyor;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.StaticWall;
import mindustry.world.blocks.logic.MessageBlock;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.units.Reconstructor;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.world.meta.*;
import rusting.core.holder.PanelHolder;
import rusting.core.holder.ShootingPanelHolder;
import rusting.world.blocks.capsules.CapsuleCenter;
import rusting.world.blocks.defense.turret.*;
import rusting.world.blocks.environment.FixedOreBlock;
import rusting.world.blocks.power.AttributeBurnerGenerator;
import rusting.world.blocks.production.ConditionalDrill;
import rusting.world.blocks.pulse.defense.*;
import rusting.world.blocks.pulse.distribution.*;
import rusting.world.blocks.pulse.production.PulseGenerator;
import rusting.world.blocks.pulse.unit.PulseReconstructor;
import rusting.world.blocks.pulse.unit.PulseUnitFactory;
import rusting.world.blocks.pulse.utility.*;

import static mindustry.type.ItemStack.with;

public class RustingBlocks implements ContentList{
    public static Block
        capsuleCenterTest,
        //environment
        //liquids
        melainLiquae,
        //floor
        //pailean
        paileanStolnen, paileanPathen, paileanWallen, paileanBarreren,
        //ebrin, drier pailean blocks
        ebrinDrylon,
        //classem
        classemStolnene, classemPathen, classemPulsen, classemWallen, classemBarrreren,
        //dripive
        dripiveGrassen, dripiveWallen,
        //ore blocks
        melonaleum, taconite,
        //crafting
        bulasteltForgery,
        //defense
        terraMound, terraMoundLarge, wol,
        //power
        waterBoilerGenerator,
        //drill
        terraPulveriser,
        //distribution
        terraConveyor,
        //pulse
        //Pulse collection
        pulseGenerator, pulseCollector,
        //Nodes
        pulseNode, pulseTesla,
        //Storage
        pulseResonator,
        //Siphon
        pulseSiphon,
        //Walls
        pulseBarrier, pulseBarrierLarge,
        //Research
        pulseResearchCenter,
        //Suport
        pulseUpkeeper,
        //particle spawning
        smallParticleSpawner,
        //storage
        fraeCore,
        //endregion storage
        //turrets
        //environment/turrets
        archangel,
        //landmines
        pulseLandmine,
        //units
        pulseFactory, enlightenmentReconstructor, ascendanceReconstructor, pulseDistributor,
        //controll
        pulseDirectionalController, pulseContactSender,
        //healer turrets
        thrum, spikent,
        //pannel turrets
        prikend, prsimdeome, prefraecon, rangi, pafleaver,
        //spawner turrets.
        octain, triagon,
        //bomerang related turrets
        refract, diffract, reflect,
        //region unit
        fraeFactory, absentReconstructor, dwindlingReconstructor,
        //logic
        fraeLog;
        
    public void load(){
        //region environment

        melainLiquae = new Floor("melain-liquae"){{
            speedMultiplier = 0.5f;
            variants = 0;
            status = RustingStatusEffects.macotagus;
            statusDuration = 350f;
            liquidDrop = Liquids.water;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
            albedo = 0.5f;
            drawLiquidLight = true;
            emitLight = true;
            lightColor = new Color(Palr.pulseChargeStart).a(0.15f);
            lightRadius = 16;
        }};

        paileanStolnen = new Floor("pailean-stolnen"){{
            speedMultiplier = 0.95f;
            variants = 3;
            attributes.set(Attribute.water, -0.85f);
        }};

        paileanPathen = new Floor("pailean-pathen"){{
            speedMultiplier = 0.8f;
            variants = 2;
            attributes.set(Attribute.water, -0.85f);
            attributes.set(Attribute.heat, 0.075f);
            blendGroup = paileanStolnen;
        }};

        ebrinDrylon = new Floor("ebrin-drylon"){{
            itemDrop = Items.sand;
            speedMultiplier = 0.75f;
            variants = 6;
            attributes.set(Attribute.water, -1f);
            attributes.set(Attribute.spores, -0.15f);
            attributes.set(Attribute.heat, 0.025f);
        }};

        classemStolnene = new Floor("classem-stolnene"){{
            speedMultiplier = 0.85f;
            variants = 3;
            emitLight = true;
            lightColor = new Color(Palr.pulseChargeStart).a(0.05f);
            lightRadius = 10;
            attributes.set(Attribute.water, 0.15f);
            attributes.set(Attribute.heat, -0.15f);
        }};


        classemPulsen = new Floor("classem-pulsen"){{
            speedMultiplier = 0.85f;
            variants = 6;
            emitLight = true;
            lightColor = new Color(Palr.pulseChargeStart).a(0.19f);
            lightRadius = 15;
            attributes.set(Attribute.water, 0.75f);
            attributes.set(Attribute.heat, -0.55f);
            attributes.set(Attribute.spores, -0.15f);
        }};

        classemPathen = new Floor("classem-pathen"){{
            speedMultiplier = 0.85f;
            variants = 2;
            emitLight = true;
            lightColor = new Color(Palr.pulseChargeStart).a(0.25f);
            lightRadius = 7;
            attributes.set(Attribute.water, 1.35f);
            attributes.set(Attribute.heat, -0.35f);
        }};

        dripiveGrassen = new Floor("dripive-grassen"){{
            speedMultiplier = 0.95f;
            attributes.set(Attribute.water, 1.14f);
            attributes.set(Attribute.spores, -0.25f);
            attributes.set(Attribute.heat, -0.35f);
        }};

        paileanWallen = new StaticWall("pailean-wallen"){{
            variants = 2;
        }};

        paileanBarreren = new StaticWall("pailean-barreren"){{
            variants = 2;
        }};

        classemWallen = new StaticWall("classem-wallen"){{
            variants = 2;
        }};

        classemBarrreren = new StaticWall("classem-barreren"){{
            variants = 2;
        }};

        dripiveWallen = new StaticWall("dripive-wallen"){{
            variants = 2;
        }};

        melonaleum = new FixedOreBlock("melonaleum"){{
            itemDrop = RustingItems.melonaleum;
            overrideMapColor = itemDrop.color;
            variants = 2;
        }};

        taconite = new FixedOreBlock("taconite"){{
            itemDrop = RustingItems.taconite;
            overrideMapColor = itemDrop.color;
            variants = 1;
        }};

        //endregion

        capsuleCenterTest = new CapsuleCenter("etst"){{
            requirements(Category.effect, with());
        }};

        //region crafting
        bulasteltForgery = new GenericCrafter("bulastelt-forgery"){{
            requirements(Category.crafting, with(Items.coal, 6, RustingItems.taconite, 7, RustingItems.bulastelt, 5));
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(RustingItems.bulastelt, 6);
            craftTime = 425f;
            size = 2;
            hasPower = false;
            hasLiquids = true;

            consumes.items(with(Items.coal, 3, RustingItems.taconite, 5));
            consumes.liquid(Liquids.water, 0.155f);
        }};
        //endregion crafting

        //region defense
        terraMound = new Wall("terra-mound"){{
            requirements(Category.defense, with(Items.coal, 6, RustingItems.taconite, 3, RustingItems.bulastelt, 1));
            size = 1;
            health = 420 * size * size;
            insulated = true;
        }};

        terraMoundLarge = new Wall("terra-mound-large"){{
            requirements(Category.defense, with(Items.coal, 24, RustingItems.taconite, 12, RustingItems.bulastelt, 4));
            size = 2;
            health = 420 * size * size;
            insulated = true;
        }};

        wol = new Wall("wol"){{
            requirements(Category.defense, with(Items.coal, 24, RustingItems.taconite, 12, RustingItems.bulastelt, 4));
            size = 1;
            health = 420 * size * size;
        }};

        //endregion defense

        //region power

        waterBoilerGenerator = new AttributeBurnerGenerator("water-boiler-generator"){{
            requirements(Category.power, with(Items.copper, 40, Items.graphite, 35, Items.lead, 50, Items.silicon, 35, Items.metaglass, 40));
            powerProduction = 3.25f;
            generateEffect = Fx.redgeneratespark;
            size = 3;
            minItemEfficiency = 0.15f;

            consumes.liquid(Liquids.water, 0.12f).optional(false, false);
        }};

        //endregion

        //region drill

        terraPulveriser = new ConditionalDrill("terra-pulveriser"){{
            requirements(Category.production, with(Items.copper, 25, Items.coal, 15, RustingItems.taconite, 15));
            size = 2;
            tier = 2;
            drops = Seq.with(
                new ItemModule(){{
                    item = RustingItems.taconite;
                    floors = Seq.with(Blocks.stone.asFloor(), Blocks.craters.asFloor(), Blocks.basalt.asFloor());
                }},
                new ItemModule(){{
                    item = Items.sand;
                    floors = Seq.with(Blocks.sand.asFloor(), Blocks.darksand.asFloor(), Blocks.sandWater.asFloor());
                }},
                new ItemModule(){{
                    item = Items.coal;
                    floors = Seq.with(Blocks.charr.asFloor());
                }}
            );

            consumes.liquid(Liquids.water, 0.05f).boost();

        }};

        //endregion

        //region distribution

        terraConveyor = new Conveyor("terra-conveyor"){{
            requirements(Category.distribution, with(Items.copper, 2, Items.coal, 1, RustingItems.bulastelt, 2));
            health = 95;
            speed = 0.04f;
            displayedSpeed = 5.5f;
        }};

        //endregion distribution

        //region pulse

        //Generates pulse. Requires some sort of Siphon to collect the pulse.
        pulseCollector = new PulseGenerator("pulse-collector"){{
            requirements(Category.power, with(Items.copper, 35, Items.coal, 15, Items.titanium, 10));
            centerResearchRequirements = with(Items.copper, 100,  Items.coal, 50, Items.titanium, 25);
            size = 1;
            canOverload = false;
            configurable = false;
            productionTime = 30;
            pulseAmount = 2.5f;
            connectionsPotential = 0;
            connectable = false;
            pulseStorage = 15;
            resistance = 0.75f;
            laserOffset = 4;
        }};

        //Generates pulse. Quite good at storing pulse, but requires additional fuel.
        pulseGenerator = new PulseGenerator("pulse-generator"){{
            requirements(Category.power, with(Items.copper, 90, Items.silicon, 55, Items.titanium, 45));
            centerResearchRequirements = with(Items.copper, 350,  Items.coal, 95, Items.graphite, 55, Items.titanium, 225, RustingItems.melonaleum, 75);
            consumes.item(RustingItems.melonaleum, 1);
            size = 3;
            canOverload = true;
            overloadCapacity = 25;
            productionTime = 30;
            pulseAmount = 10f;
            pulseReloadTime = 10;
            energyTransmission = 4.5f;
            connectionsPotential = 3;
            pulseStorage = 75;
            resistance = 0.25f;
            laserOffset = 10;
            laserRange = 7;
        }};

        //Loses power fast, but is great at transmitting pulses to far blocks.
        pulseNode = new PulseNode("pulse-node"){{
            requirements(Category.power, with(Items.copper, 5, Items.lead, 4, Items.titanium, 3));
            centerResearchRequirements = with(Items.copper, 120, Items.lead, 95, Items.titanium, 65);
            size = 1;
            powerLoss = 0.0025f;
            pulseReloadTime = 15;
            energyTransmission = 3f;
            pulseStorage = 25;
            resistance = 0.075f;
            laserRange = 13;
            canOverload = false;
        }};

        //Shoots lightning around itself when overloaded. Easly overloads. Acts as a large power node, with two connections, but slower reload
        pulseTesla = new PulseNode("pulse-tesla"){{
            requirements(Category.power, with(Items.copper, 85, Items.lead, 65, Items.graphite, 25, Items.titanium, 20));
            centerResearchRequirements = with(Items.copper, 365, Items.lead, 125, Items.coal, 85, Items.titanium, 80);
            size = 2;
            projectile = RustingBullets.craeBolt;
            projectileChanceModifier = 0.15f;
            powerLoss = 0.00835f;
            pulseReloadTime = 35;
            minRequiredPulsePercent = 0.15f;
            connectionsPotential = 2;
            energyTransmission = 10f;
            pulseStorage = 45;
            overloadCapacity = 15;
            resistance = 0.075f;
            laserOffset = 3;
            laserRange = 18;
            canOverload = true;
        }};

        //stores power for later usage less effectively than nodes, but stores more power. Transmits power to blocks nearby with less pulse power percentage.
        pulseResonator = new ConductivePulseBlock("pulse-resonator"){{
            requirements(Category.power, with(Items.copper, 35, Items.silicon, 20, Items.titanium, 10));
            centerResearchRequirements = with(Items.copper, 175, Items.coal, 35, Items.silicon, 90, Items.titanium, 65);
            size = 1;
            powerLoss = 0.00425f;
            resistance = 0;
            pulseStorage = 175;
            canOverload = false;
        }};

        pulseSiphon = new PulseSiphon("pulse-siphon"){{
            requirements(Category.power, with(Items.copper, 10, Items.silicon, 20, Items.titanium, 15));
            centerResearchRequirements = with(Items.copper, 125,  Items.coal, 65, Items.graphite, 45, Items.titanium, 35);
            size = 1;
            powerLoss = 0.000035f;
            siphonAmount = 1.5f;
            pulseReloadTime = 35;
            pulseStorage = 35;
            laserRange = 6;
            canOverload = false;
        }};

        pulseBarrier = new PulseBarrier("pulse-barrier"){{
            requirements(Category.defense, with(Items.copper, 8, Items.graphite, 6, Items.titanium, 5));
            centerResearchRequirements = with(Items.copper, 115, Items.coal, 65, Items.titanium, 30);
            size = 1;
            health = 410 * size * size;
            powerLoss = 0.000035f;
            pulseStorage = 55;
            canOverload = false;
        }};

        pulseBarrierLarge = new PulseBarrier("pulse-barrier-large"){{
            requirements(Category.defense, with(Items.copper, 32, Items.graphite, 24, Items.titanium, 20));
            centerResearchRequirements = with(Items.copper, 450, Items.graphite, 75, Items.titanium, 120);
            size = 2;
            health = 410 * size * size;
            powerLoss = 0.000035f;
            pulseStorage = 135;
            laserOffset = 5.5f;
            canOverload = false;
        }};

        pulseResearchCenter = new PulseResearchBlock("pulse-research-center"){{
            requirements(Category.effect, with(Items.copper, 65, Items.lead, 50, Items.coal, 25));
            centerResearchRequirements = with(Items.copper, 40,  Items.coal, 15);
            size = 2;
            fieldNames.add("pulseStorage");
            fieldNames.add("canOverload");
        }};

        pulseUpkeeper = new PulseChainNode("pulse-upkeeper"){{
            requirements(Category.effect, with(Items.copper, 95, Items.lead, 75, Items.silicon, 45, Items.titanium, 25));
            centerResearchRequirements = with(Items.copper, 550,  Items.coal, 355, Items.metaglass, 100, Items.graphite, 125, Items.titanium, 175, RustingItems.melonaleum, 75);
            size = 2;
            powerLoss = 0.0000155f;
            minRequiredPulsePercent = 0.5f;
            pulseReloadTime = 165;
            connectionsPotential = 4;
            energyTransmission = 0.5f;
            pulseStorage = 70;
            overloadCapacity = 30;
            laserRange = 10;
            laserOffset = 9;
            healingPercentCap = 13;
            healPercent = 26;
            healPercentFalloff = healPercent/3;
            overdrivePercent = 65;
        }};

        smallParticleSpawner = new PulseParticleSpawner("small-particle-spawner"){{
            requirements(Category.effect, with(Items.copper, 300, Items.lead, 115, Items.metaglass, 50, Items.titanium, 45));
            centerResearchRequirements = with(Items.copper, 350,  Items.coal, 95, Items.graphite, 55, Items.titanium, 225);
            flags = EnumSet.of(BlockFlag.generator);
            effects = new Effect[] {Fx.ballfire, Fx.burning, Fx.fire};
            size = 1;
            health = 35 * size * size;
            projectileChanceModifier = 0;
            customConsumes.pulse = 0.25f;
            cruxInfiniteConsume = true;
            pulseStorage = 70;
            overloadCapacity = 30;
            powerLoss = 0;
            minRequiredPulsePercent = 0;
            canOverload = true;
        }};

        fraeCore = new CoreBlock("frae-core"){{
            requirements(Category.effect, BuildVisibility.editorOnly, with(Items.copper, 1000, Items.lead, 800));
            alwaysUnlocked = false;

            unitType = RustingUnits.duoly;
            health = 2100;
            itemCapacity = 6500;
            size = 3;

            unitCapModifier = 13;
        }};

        archangel = new DysfunctionalMonolith("archangel"){{
            requirements(Category.effect, with(Items.copper, 300, Items.lead, 115, Items.metaglass, 50, Items.titanium, 45));
            centerResearchRequirements = with(Items.copper, 350,  Items.coal, 95, Items.graphite, 55, Items.titanium, 225);
            flags = EnumSet.of(BlockFlag.turret);
            size = 3;
            health = 135 * size * size;
            projectile = RustingBullets.craeWeaver;
            projectileChanceModifier = 0;
            reloadTime = 85;
            shots = 2;
            bursts = 3;
            burstSpacing = 3;
            inaccuracy = 5;
            customConsumes.pulse = 15;
            cruxInfiniteConsume = true;
            pulseStorage = 70;
            overloadCapacity = 30;
            powerLoss = 0;
            minRequiredPulsePercent = 0;
            canOverload = true;
        }};

        //region landmines
        pulseLandmine = new PulseLandmine("pulse-landmine") {{
            requirements(Category.effect, with(Items.lead, 15, Items.silicon, 10, RustingItems.melonaleum, 5));
            centerResearchRequirements = with(Items.copper, 45,  Items.coal, 245, Items.graphite, 95, Items.silicon, 55, RustingItems.melonaleum, 15);
            health = 135;
            reloadTime = 85;
            shots = 3;
            customConsumes.pulse = 10;
            pulseStorage = 75;
            cruxInfiniteConsume = true;
            canOverload = false;
            powerLoss = 0;
        }};


        //region units

        pulseFactory = new PulseUnitFactory("pulse-factory"){{
            requirements(Category.units, with(Items.copper, 75, Items.lead, 60, Items.coal, 35, Items.titanium, 25));
            centerResearchRequirements = with(Items.copper, 145,  Items.lead, 145, Items.graphite, 55, Items.titanium, 85, Items.pyratite, 35);
            customConsumes.pulse = 10f;
            powerLoss = 0.00155f;
            minRequiredPulsePercent = 0.35f;
            laserOffset = 8f;
            pulseStorage = 55;
            overloadCapacity = 25;
            size = 3;
            plans.addAll(
                new UnitPlan(RustingUnits.duono, 1920, ItemStack.with(Items.lead, 25, Items.silicon, 35, Items.titanium, 10)),
                new UnitPlan(RustingUnits.fahrenheit, 1250, ItemStack.with(Items.lead, 35, Items.silicon, 15, RustingItems.melonaleum, 10))
            );
        }};

        enlightenmentReconstructor = new PulseReconstructor("enlightenment-reconstructor") {{
            requirements(Category.units, with(Items.copper, 135, Items.lead, 85, Items.silicon, 45, Items.titanium, 35));
            centerResearchRequirements = with(Items.copper, 450,  Items.lead, 375, Items.silicon, 145, Items.titanium, 135, Items.pyratite, 75, RustingItems.melonaleum, 45);
            consumes.items(ItemStack.with(Items.silicon, 35, Items.titanium, 15, RustingItems.melonaleum, 10));
            customConsumes.pulse = 25f;
            powerLoss = 0.00155f;
            minRequiredPulsePercent = 0.65f;
            laserOffset = 8f;
            pulseStorage = 85;
            canOverload = false;
            size = 3;
            upgrades.add(
                new UnitType[]{RustingUnits.duono, RustingUnits.duoly},
                new UnitType[]{RustingUnits.marrow, RustingUnits.metaphys}
            );
            constructTime = 720;
        }};

        ascendanceReconstructor = new PulseReconstructor("ascendance-reconstructor") {{
            requirements(Category.units, with(Items.lead, 465, Items.metaglass, 245, Items.pyratite, 85, Items.titanium, 85));
            centerResearchRequirements = with(Items.lead, 1255, Items.silicon, 455, Items.titanium, 235, Items.pyratite, 145, RustingItems.melonaleum, 125);
            consumes.items(ItemStack.with(Items.silicon, 65, Items.titanium, 25, Items.pyratite, 5, RustingItems.melonaleum, 15));
            customConsumes.pulse = 65f;
            powerLoss = 0.00155f;
            minRequiredPulsePercent = 0.55f;
            laserOffset = 8f;
            pulseStorage = 145;
            canOverload = false;
            size = 5;
            upgrades.add(
                    new UnitType[]{RustingUnits.duoly, RustingUnits.duanga},
                    new UnitType[]{RustingUnits.metaphys, RustingUnits.ribigen}
            );
            constructTime = 720;
        }};

        //region logic

        pulseDirectionalController = new PulseController("pulse-controller"){{
            requirements(Category.effect, with(Items.lead, 465, Items.metaglass, 245, Items.pyratite, 85, Items.titanium, 85));

        }};

        pulseContactSender = new PulseContactSender("pulse-sender"){{
            requirements(Category.effect, with(Items.lead, 465, Items.metaglass, 245, Items.pyratite, 85, Items.titanium, 85));

        }};

        //endregion pulse

        //region turrets

        thrum = new HealerBeamTurret("thrum"){{
            requirements(Category.turret, with(Items.copper, 60, Items.lead, 25, Items.silicon, 25));
            health = 220;
            size = 1;
            reloadTime = 60;
            range = 115;
            shootCone = 1;
            powerUse = 0.5f;
            rotateSpeed = 10;
            squares = 3;
            alphaFalloff = 0.65f;
            maxEffectSize = 4;
            healing = 40;
            targetAir = true;
            targetGround = true;
        }};

        spikent = new AreaHealerBeamTurret("spikent"){{
            requirements(Category.turret, with(Items.copper, 125, Items.lead, 85, Items.silicon, 55, RustingItems.melonaleum, 35));
            health = 650;
            size = 2;
            reloadTime = 35;
            range = 150;
            shootCone = 3;
            powerUse = 0.8f;
            rotateSpeed = 8;
            alphaFalloff = 0.35f;
            healing = 35;
            healRadius = 18;
            targetAir = true;
            targetGround = true;
        }};

        prikend = new PowerTurret("prikend"){{
            requirements(Category.turret, with(Items.copper, 60, Items.lead, 45, Items.silicon, 35));
            range = 185f;
            shootLength = 2;
            chargeEffects = 7;
            recoilAmount = 2f;
            reloadTime = 75f;
            cooldown = 0.03f;
            powerUse = 1.25f;
            shootShake = 2f;
            shootEffect = Fx.hitFlameSmall;
            smokeEffect = Fx.none;
            heatColor = Color.orange;
            size = 1;
            health = 280 * size * size;
            shootSound = Sounds.bigshot;
            shootType = RustingBullets.fossilShard;
            shots = 2;
            burstSpacing = 15f;
            inaccuracy = 2;
        }};

        prsimdeome = new PanelTurret("prsimdeome"){{
            requirements(Category.turret, with(Items.copper, 85, Items.lead, 70, Items.silicon, 50, RustingItems.bulastelt, 35));
            range = 165f;
            chargeEffects = 7;
            recoilAmount = 2f;
            reloadTime = 96f;
            cooldown = 0.03f;
            powerUse = 4f;
            shootShake = 2f;
            shootEffect = Fxr.shootMhemFlame;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            size = 2;
            health = 280 * size * size;
            shootSound = Sounds.flame2;
            shootType = RustingBullets.mhemShard;
            shots = 6;
            spread = 10f;
            burstSpacing = 5f;
            inaccuracy = 10;
            panels.add(
                new PanelHolder(name){{
                    panelX = 6;
                    panelY = -4;
                }}
            );
        }};

        prefraecon = new PanelTurret("prefraecon"){{
            requirements(Category.turret, with(Items.titanium, 115, Items.silicon, 65, RustingItems.bulastelt, 55, RustingItems.melonaleum, 45));
            range = 200f;
            recoilAmount = 2f;
            reloadTime = 65f;
            powerUse = 6f;
            shootShake = 2f;
            shootEffect = Fxr.shootMhemFlame;
            smokeEffect = Fx.none;
            heatColor = Pal.darkPyraFlame;
            size = 3;
            health = 280 * size * size;
            shootSound = Sounds.release;
            shootType = RustingBullets.fraeShard;
            panels.add(
                new PanelHolder(name){{
                    panelX = 10;
                    panelY = -4;
                }}
            );
        }};

        rangi = new PanelTurret("rangi"){{
            requirements(Category.turret, with(Items.metaglass, 75, Items.silicon, 55, RustingItems.taconite, 45, RustingItems.bulastelt, 25));
            range = 166f;
            recoilAmount = 2f;
            reloadTime = 315f;
            shootCone = 360;
            powerUse = 8f;
            shootShake = 2f;
            shootEffect = Fxr.shootMhemFlame;
            smokeEffect = Fx.none;
            heatColor = Palr.dustriken;
            size = 3;
            health = 280 * size * size;
            shootSound = Sounds.release;
            shootType = RustingBullets.cloudyVortex;
        }};

        pafleaver  = new PanelTurret("pafleaver"){{
            //requirements(Category.turret, with(Items.copper, 60, Items.lead, 70, Items.silicon, 50));
            range = 260f;
            recoilAmount = 2f;
            reloadTime = 60f;
            powerUse = 6f;
            shootShake = 2f;
            shootEffect = Fxr.shootMhemFlame;
            smokeEffect = Fx.none;
            heatColor = Pal.darkPyraFlame;
            size = 4;
            health = 280 * size * size;
            shootSound = Sounds.flame2;
            shootType = RustingBullets.paveShard;
            shots = 1;
            panels.add(
                new PanelHolder(name + "1"){{
                    panelX = 10.75;
                    panelY = -4.5;
                }},
                new PanelHolder(name + "2"){{
                    panelX = -10.75;
                    panelY = -4.5;
                }},
                new ShootingPanelHolder(name + "1"){{
                    panelX = 13.75;
                    panelY = -3.75;
                    shootType = RustingBullets.mhemShard;
                }},
                new ShootingPanelHolder(name + "2"){{
                    panelX = -13.75;
                    panelY = -3.75;
                    shootType = RustingBullets.mhemShard;
                }}
            );
        }};

        octain = new ItemTurret("octain"){{
            requirements(Category.turret, with(Items.graphite, 35, Items.metaglass, 25, RustingItems.taconite, 65));
            size = 2;
            health = 275 * size * size;
            ammo(
                    Items.metaglass, RustingBullets.spawnerGlass,
                    RustingItems.bulastelt, RustingBullets.spawnerBulat
            );
            shots = 2;
            burstSpacing = 5;
            inaccuracy = 2;
            reloadTime = 125f;
            recoilAmount = 2.5f;
            range = 175f;
            shootCone = 25f;
            shootSound = Sounds.release;
            coolantMultiplier = 0.35f;
        }};

        triagon = new ItemTurret("triagon"){{
            requirements(Category.turret, with(Items.graphite, 35, Items.metaglass, 25, RustingItems.taconite, 65));
            size = 3;
            health = 275 * size * size;
            ammo(
                Items.pyratite, RustingBullets.flamstrikenVortex,
                RustingItems.melonaleum, RustingBullets.boltingVortex
            );
            shots = 1;
            reloadTime = 325f;
            recoilAmount = 2.5f;
            range = 175f;
            shootCone = 25f;
            shootSound = Sounds.release;
            coolantMultiplier = 0.35f;
        }};


        refract = new ItemTurret("refract"){{
            requirements(Category.turret, with(Items.copper, 40, Items.graphite, 17));
            ammo(
                    Items.graphite, RustingBullets.denseLightRoundaboutLeft,
                    RustingItems.melonaleum, RustingBullets.craeLightRoundaboutLeft

            );

            health = 340;

            shots = 5;
            burstSpacing = 5;
            reloadTime = 105f;
            recoilAmount = 1.5f;
            range = 135f;
            inaccuracy = 15f;
            shootCone = 15f;
            shootSound = Sounds.bang;
        }};

        diffract = new ItemTurret("diffract"){{
            requirements(Category.turret, with(Items.copper, 40, Items.graphite, 17));
            ammo(
                Items.graphite, RustingBullets.craeLightGlaive
            );

            health = 960;

            size = 2;
            shots = 1;

            reloadTime = 120f;
            recoilAmount = 1.5f;
            range = 165f;
            inaccuracy = 0;
            shootCone = 15f;
            shootSound = Sounds.bang;
        }};

        reflect = new BoomerangTurret("reflect"){{
            requirements(Category.turret, with(Items.copper, 40, Items.graphite, 17));
            ammo(
                Items.graphite, RustingBullets.craeLightGlaiveLeft,
                RustingItems.melonaleum, RustingBullets.craeLightGlaive
            );

            health = 1460;

            size = 3;
            shots = 8;
            spread = 45;

            burstSpacing = 7.5f;
            shootLength = 11;
            reloadTime = 60f;
            recoilAmount = 0f;
            range = 165f;
            inaccuracy = 0;
            shootCone = 360f;
            rotateSpeed = 1;
            shootSound = Sounds.bang;
        }};

        //endregion


        //region unit

        fraeFactory = new UnitFactory("frae-factory"){{
            requirements(Category.units, with(Items.copper, 75, RustingItems.taconite, 55, RustingItems.bulastelt, 30));
            plans = Seq.with(
                new UnitPlan(RustingUnits.marrow, 2345, with(Items.silicon, 35, Items.copper, 15, RustingItems.taconite, 25))
            );
            size = 3;
            consumes.power(0.85f);
        }};

        absentReconstructor = new Reconstructor("absent-reconstructor"){{
            requirements(Category.units, with(Items.lead, 465, Items.metaglass, 245, Items.pyratite, 85, Items.titanium, 85));
            consumes.items(ItemStack.with(Items.silicon, 65, Items.titanium, 25, Items.pyratite, 5, RustingItems.melonaleum, 15));
            size = 3;
            upgrades.add(
                    new UnitType[]{RustingUnits.marrow, RustingUnits.metaphys}
            );
            constructTime = 854;
        }};

        dwindlingReconstructor = new Reconstructor("dwindling-reconstructor"){{
            requirements(Category.units, with(Items.lead, 465, Items.metaglass, 245, Items.pyratite, 85, Items.titanium, 85));
            consumes.items(ItemStack.with(Items.silicon, 65, Items.titanium, 25, Items.pyratite, 5, RustingItems.melonaleum, 15));
            size = 5;
            upgrades.add(
                    new UnitType[]{RustingUnits.metaphys, RustingUnits.ribigen}
            );
            constructTime = 1460;
        }};

        pulseDistributor = new PulsePoint("pulse-distributor"){{
            requirements(Category.units, with(Items.lead, 465, Items.metaglass, 245, Items.pyratite, 85, Items.titanium, 85));

        }};

        //endregion

        //region, *sigh* logic
        fraeLog = new MessageBlock("frae-log"){{
            buildVisibility = BuildVisibility.editorOnly;
            targetable = false;
            breakable = false;
            replaceable = false;
            destructible = false;
        }};
        //endregion
    }
}
