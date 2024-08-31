/*     */ package Koishi;
/*     */
/*     */ import Koishi.cards.AbstractIdCard;
/*     */ import Koishi.cards.Attacks.Common.BasicStrike;
/*     */ import Koishi.cards.Attacks.Common.BloodcurdlingScream;
/*     */ import Koishi.cards.Attacks.Common.DreadfulBlow;
/*     */ import Koishi.cards.Attacks.Common.HauntingSlash;
/*     */ import Koishi.cards.Attacks.Common.Jaunt;
/*     */ import Koishi.cards.Attacks.Common.ParalyzingFear;
/*     */ import Koishi.cards.Attacks.Common.PhantomStrike;
/*     */ import Koishi.cards.Attacks.Common.Prune;
/*     */ import Koishi.cards.Attacks.Common.RacingHeart;
/*     */ import Koishi.cards.Attacks.Common.SpiritedAway;
/*     */ import Koishi.cards.Attacks.Common.StingingMind;
/*     */ import Koishi.cards.Attacks.Common.SubconsciousSweep;
/*     */ import Koishi.cards.Attacks.Rare.GrowingPain;
/*     */ import Koishi.cards.Attacks.Rare.MentalBreakdown;
/*     */ import Koishi.cards.Attacks.Rare.RuptureMind;
/*     */ import Koishi.cards.Attacks.Rare.SilentAndRestless;
/*     */ import Koishi.cards.Attacks.Rare.SuperEgo;
/*     */ import Koishi.cards.Attacks.Uncommon.Catatonia;
/*     */ import Koishi.cards.Attacks.Uncommon.HeartAttack;
/*     */ import Koishi.cards.Attacks.Uncommon.LastRemote;
/*     */ import Koishi.cards.Attacks.Uncommon.MindNumbingTerror;
/*     */ import Koishi.cards.Attacks.Uncommon.StrangeCloudFist;
/*     */ import Koishi.cards.Attacks.Uncommon.TraumaticStroke;
/*     */ import Koishi.cards.Attacks.Uncommon.TremblingHands;
/*     */ import Koishi.cards.Attacks.Uncommon.UnseenTerror;
/*     */ import Koishi.cards.Attacks.Uncommon.YoukaiPolygraph;
/*     */ import Koishi.cards.Powers.Rare.ConfinedInnocent;
/*     */ import Koishi.cards.Powers.Rare.Ego;
/*     */ import Koishi.cards.Powers.Rare.FormlessExistence;
/*     */ import Koishi.cards.Powers.Rare.HeartStoppingHorror;
/*     */ import Koishi.cards.Powers.Rare.Heartbroken;
/*     */ import Koishi.cards.Powers.Rare.TerrifyingSpectre;
/*     */ import Koishi.cards.Powers.Uncommon.BramblyRoseGarden;
/*     */ import Koishi.cards.Powers.Uncommon.FidgetySnatcher;
/*     */ import Koishi.cards.Powers.Uncommon.FreudianInstinct;
/*     */ import Koishi.cards.Powers.Uncommon.UnconsciousUrges;
/*     */ import Koishi.cards.Powers.Uncommon.Untouchable;
/*     */ import Koishi.cards.Powers.Uncommon.VengefulSpirit;
/*     */ import Koishi.cards.Skills.Common.BasicDefend;
/*     */ import Koishi.cards.Skills.Common.CatchAndRose;
/*     */ import Koishi.cards.Skills.Common.EmbryosDream;
/*     */ import Koishi.cards.Skills.Common.FleetingPhantom;
/*     */ import Koishi.cards.Skills.Common.HeartfeltFancy;
/*     */ import Koishi.cards.Skills.Common.JumpScare;
/*     */ import Koishi.cards.Skills.Common.PhantomBarrier;
/*     */ import Koishi.cards.Skills.Common.Provoke;
/*     */ import Koishi.cards.Skills.Common.ReflexRadar;
/*     */ import Koishi.cards.Skills.Common.SubterraneanRose;
/*     */ import Koishi.cards.Skills.Common.UnansweredLove;
/*     */ import Koishi.cards.Skills.Common.UnconsciousUprising;
/*     */ import Koishi.cards.Skills.Rare.ConditionedTeleport;
/*     */ import Koishi.cards.Skills.Rare.FadingMemory;
/*     */ import Koishi.cards.Skills.Rare.ImGoingToCallYouNow;
/*     */ import Koishi.cards.Skills.Rare.MindStellarRelief;
/*     */ import Koishi.cards.Skills.Rare.PerfectMindControl;
/*     */ import Koishi.cards.Skills.Rare.RollingInRichesHeart;
/*     */ import Koishi.cards.Skills.Rare.RoseHell;
/*     */ import Koishi.cards.Skills.Uncommon.ApparitionsStalkTheNight;
/*     */ import Koishi.cards.Skills.Uncommon.Bloodlust;
/*     */ import Koishi.cards.Skills.Uncommon.DNAsFlaw;
/*     */ import Koishi.cards.Skills.Uncommon.DanmakuParanoia;
/*     */ import Koishi.cards.Skills.Uncommon.EmbersOfLove;
/*     */ import Koishi.cards.Skills.Uncommon.FourthEye;
/*     */ import Koishi.cards.Skills.Uncommon.GeneticsOfTheUnconscious;
/*     */ import Koishi.cards.Skills.Uncommon.IdleWhim;
/*     */ import Koishi.cards.Skills.Uncommon.MassHysteria;
/*     */ import Koishi.cards.Skills.Uncommon.PhilosophyOfTheDespised;
/*     */ import Koishi.cards.Skills.Uncommon.Possession;
/*     */ import Koishi.cards.Skills.Uncommon.PredatoryInstincts;
/*     */ import Koishi.cards.Skills.Uncommon.ReleaseOfTheId;
/*     */ import Koishi.cards.Skills.Uncommon.RorschachInDanmaku;
/*     */ import Koishi.cards.Skills.Uncommon.SprinkleStarAndHeart;
/*     */ import Koishi.cards.Skills.Uncommon.Vanish;
/*     */ import Koishi.cards.Skills.Uncommon.Whimsy;
/*     */ import Koishi.characters.KoishiCharacter;
/*     */ import Koishi.relics.AHoleWhereASisterShouldBe;
/*     */ import Koishi.relics.BloodstainedWhiteRose;
/*     */ import Koishi.relics.ColorfulDays;
/*     */ import Koishi.relics.EchoesOfADeadGirl;
/*     */ import Koishi.relics.ImaginaryFriend;
/*     */ import Koishi.relics.ImperfectMetamorphosis;
/*     */ import Koishi.relics.LettersToReimu;
/*     */ import Koishi.relics.TeethAndClaws;
/*     */ import Koishi.util.IDCheckDontTouchPls;
/*     */ import Koishi.util.TextureLoader;
/*     */ import Koishi.variables.DefaultSecondMagicNumber;
/*     */ import basemod.BaseMod;
/*     */ import basemod.ModPanel;
/*     */ import basemod.abstracts.CustomCard;
/*     */ import basemod.abstracts.DynamicVariable;
/*     */ import basemod.interfaces.EditCardsSubscriber;
/*     */ import basemod.interfaces.EditCharactersSubscriber;
/*     */ import basemod.interfaces.EditKeywordsSubscriber;
/*     */ import basemod.interfaces.EditRelicsSubscriber;
/*     */ import basemod.interfaces.EditStringsSubscriber;
/*     */ import basemod.interfaces.ISubscriber;
/*     */ import basemod.interfaces.OnStartBattleSubscriber;
/*     */ import basemod.interfaces.PostBattleSubscriber;
/*     */ import basemod.interfaces.PostInitializeSubscriber;
/*     */ import basemod.interfaces.PostPowerApplySubscriber;
/*     */ import basemod.interfaces.PreMonsterTurnSubscriber;
/*     */ import basemod.interfaces.SetUnlocksSubscriber;
/*     */ import basemod.interfaces.StartGameSubscriber;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.Texture;
/*     */ import com.evacipated.cardcrawl.mod.stslib.Keyword;
/*     */ import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
/*     */ import com.google.gson.Gson;
/*     */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*     */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*     */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*     */ import com.megacrit.cardcrawl.core.Settings;
/*     */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*     */ import com.megacrit.cardcrawl.helpers.CardHelper;
/*     */ import com.megacrit.cardcrawl.localization.CardStrings;
/*     */ import com.megacrit.cardcrawl.localization.CharacterStrings;
/*     */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*     */ import com.megacrit.cardcrawl.localization.RelicStrings;
/*     */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*     */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*     */ import com.megacrit.cardcrawl.relics.AbstractRelic;
/*     */ import com.megacrit.cardcrawl.rooms.AbstractRoom;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SpireInitializer
/*     */ public class KoishiMod
/*     */   implements EditCardsSubscriber, EditRelicsSubscriber, EditStringsSubscriber, EditKeywordsSubscriber, EditCharactersSubscriber, PostInitializeSubscriber, OnStartBattleSubscriber, PostBattleSubscriber, StartGameSubscriber, SetUnlocksSubscriber, PostPowerApplySubscriber, PreMonsterTurnSubscriber
/*     */ {
/* 150 */   public static final Logger logger = LogManager.getLogger(KoishiMod.class.getName());
/*     */   
/*     */   private static String modID;
/*     */   
/*     */   private static final String MODNAME = "Koishi";
/*     */   
/*     */   private static final String AUTHOR = "Darkglade";
/*     */   private static final String DESCRIPTION = "My hat is my friend. It helps me relax.";
/* 158 */   public static int intangibleCount = 0;
/* 159 */   public static int debuffCount = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean appliedDebuffThisTurn = false;
/*     */ 
/*     */   
/* 166 */   public static final Color DARK_GREEN = CardHelper.getColor(2, 40, 0);
/*     */   
/*     */   private static final String ATTACK_GREEN = "KoishiResources/images/512/bg_attack_green.png";
/*     */   
/*     */   private static final String SKILL_GREEN = "KoishiResources/images/512/bg_skill_green.png";
/*     */   
/*     */   private static final String POWER_GREEN = "KoishiResources/images/512/bg_power_green.png";
/*     */   
/*     */   private static final String ENERGY_ORB_DEFAULT_GRAY = "KoishiResources/images/512/card_default_gray_orb.png";
/*     */   
/*     */   private static final String CARD_ENERGY_ORB = "KoishiResources/images/512/card_small_orb.png";
/*     */   
/*     */   private static final String ATTACK_GREEN_PORTRAIT = "KoishiResources/images/1024/bg_attack_green.png";
/*     */   
/*     */   private static final String SKILL_GREEN_PORTRAIT = "KoishiResources/images/1024/bg_skill_green.png";
/*     */   
/*     */   private static final String POWER_GREEN_PORTRAIT = "KoishiResources/images/1024/bg_power_green.png";
/*     */   
/*     */   private static final String ENERGY_ORB_DEFAULT_GRAY_PORTRAIT = "KoishiResources/images/1024/card_orb.png";
/*     */   
/*     */   private static final String THE_DEFAULT_BUTTON = "KoishiResources/images/charSelect/KoishiButton.png";
/*     */   private static final String THE_DEFAULT_PORTRAIT = "KoishiResources/images/charSelect/KoishiCharacterPortrait.png";
/*     */   public static final String THE_DEFAULT_SHOULDER_1 = "KoishiResources/images/char/defaultCharacter/shoulder.png";
/*     */   public static final String THE_DEFAULT_SHOULDER_2 = "KoishiResources/images/char/defaultCharacter/shoulder2.png";
/*     */   public static final String THE_DEFAULT_CORPSE = "KoishiResources/images/char/defaultCharacter/corpse.png";
/*     */   public static final String BADGE_IMAGE = "KoishiResources/images/Badge.png";
/*     */   
/*     */   public static String makeCardPath(String resourcePath) {
/* 194 */     return getModID() + "Resources/images/cards/" + resourcePath;
/*     */   }
/*     */   
/*     */   public static String makeRelicPath(String resourcePath) {
/* 198 */     return getModID() + "Resources/images/relics/" + resourcePath;
/*     */   }
/*     */   
/*     */   public static String makeRelicOutlinePath(String resourcePath) {
/* 202 */     return getModID() + "Resources/images/relics/outline/" + resourcePath;
/*     */   }
/*     */   
/*     */   public static String makeEffectPath(String resourcePath) {
/* 206 */     return getModID() + "Resources/images/effects/" + resourcePath;
/*     */   }
/*     */   
/*     */   public static String makePowerPath(String resourcePath) {
/* 210 */     return getModID() + "Resources/images/powers/" + resourcePath;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KoishiMod() {
/* 221 */     logger.info("Subscribe to BaseMod hooks");
/*     */     
/* 223 */     BaseMod.subscribe((ISubscriber)this);
/*     */     
/* 225 */     setModID("Koishi");
/*     */     
/* 227 */     logger.info("Done subscribing");
/*     */     
/* 229 */     logger.info("Creating the color " + KoishiCharacter.Enums.COLOR_DARK_GREEN.toString());
/*     */     
/* 231 */     BaseMod.addColor(KoishiCharacter.Enums.COLOR_DARK_GREEN, DARK_GREEN, DARK_GREEN, DARK_GREEN, DARK_GREEN, DARK_GREEN, DARK_GREEN, DARK_GREEN, "KoishiResources/images/512/bg_attack_green.png", "KoishiResources/images/512/bg_skill_green.png", "KoishiResources/images/512/bg_power_green.png", "KoishiResources/images/512/card_default_gray_orb.png", "KoishiResources/images/1024/bg_attack_green.png", "KoishiResources/images/1024/bg_skill_green.png", "KoishiResources/images/1024/bg_power_green.png", "KoishiResources/images/1024/card_orb.png", "KoishiResources/images/512/card_small_orb.png");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 237 */     logger.info("Done creating the color");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setModID(String ID) {
/* 245 */     Gson coolG = new Gson();
/*     */     
/* 247 */     InputStream in = KoishiMod.class.getResourceAsStream("/IDCheckStringsDONT-EDIT-AT-ALL.json");
/* 248 */     IDCheckDontTouchPls EXCEPTION_STRINGS = (IDCheckDontTouchPls)coolG.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), IDCheckDontTouchPls.class);
/* 249 */     logger.info("You are attempting to set your mod ID as: " + ID);
/* 250 */     if (ID.equals(EXCEPTION_STRINGS.DEFAULTID))
/* 251 */       throw new RuntimeException(EXCEPTION_STRINGS.EXCEPTION); 
/* 252 */     if (ID.equals(EXCEPTION_STRINGS.DEVID)) {
/* 253 */       modID = EXCEPTION_STRINGS.DEFAULTID;
/*     */     } else {
/* 255 */       modID = ID;
/*     */     } 
/* 257 */     logger.info("Success! ID is " + modID);
/*     */   }
/*     */   
/*     */   public static String getModID() {
/* 261 */     return modID;
/*     */   }
/*     */   
/*     */   private static void pathCheck() {
/* 265 */     Gson coolG = new Gson();
/*     */     
/* 267 */     InputStream in = KoishiMod.class.getResourceAsStream("/IDCheckStringsDONT-EDIT-AT-ALL.json");
/* 268 */     IDCheckDontTouchPls EXCEPTION_STRINGS = (IDCheckDontTouchPls)coolG.fromJson(new InputStreamReader(in, StandardCharsets.UTF_8), IDCheckDontTouchPls.class);
/* 269 */     String packageName = KoishiMod.class.getPackage().getName();
/* 270 */     FileHandle resourcePathExists = Gdx.files.internal(getModID() + "Resources");
/* 271 */     if (!modID.equals(EXCEPTION_STRINGS.DEVID)) {
/* 272 */       if (!packageName.equals(getModID())) {
/* 273 */         throw new RuntimeException(EXCEPTION_STRINGS.PACKAGE_EXCEPTION + getModID());
/*     */       }
/* 275 */       if (!resourcePathExists.exists()) {
/* 276 */         throw new RuntimeException(EXCEPTION_STRINGS.RESOURCE_FOLDER_EXCEPTION + getModID() + "Resources");
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void initialize() {
/* 286 */     logger.info("========================= Initializing Default Mod. Hi. =========================");
/* 287 */     KoishiMod defaultmod = new KoishiMod();
/* 288 */     logger.info("========================= /Default Mod Initialized. Hello World./ =========================");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void receiveEditCharacters() {
/* 298 */     logger.info("Beginning to edit characters. Add " + KoishiCharacter.Enums.KOISHI.toString());
/*     */     
/* 300 */     BaseMod.addCharacter((AbstractPlayer)new KoishiCharacter("the Default", KoishiCharacter.Enums.KOISHI), "KoishiResources/images/charSelect/KoishiButton.png", "KoishiResources/images/charSelect/KoishiCharacterPortrait.png", KoishiCharacter.Enums.KOISHI);
/*     */ 
/*     */     
/* 303 */     logger.info("Added " + KoishiCharacter.Enums.KOISHI.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void receivePostInitialize() {
/* 313 */     logger.info("Loading badge image and mod options");
/*     */ 
/*     */     
/* 316 */     Texture badgeTexture = TextureLoader.getTexture("KoishiResources/images/Badge.png");
/*     */ 
/*     */     
/* 319 */     ModPanel settingsPanel = new ModPanel();
/*     */     
/* 321 */     BaseMod.registerModBadge(badgeTexture, "Koishi", "Darkglade", "My hat is my friend. It helps me relax.", settingsPanel);
/*     */     
/* 323 */     logger.info("Done loading badge Image and mod options");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void receiveEditRelics() {
/* 336 */     logger.info("Adding relics");
/*     */ 
/*     */     
/* 339 */     BaseMod.addRelicToCustomPool((AbstractRelic)new ImaginaryFriend(), KoishiCharacter.Enums.COLOR_DARK_GREEN);
/* 340 */     BaseMod.addRelicToCustomPool((AbstractRelic)new BloodstainedWhiteRose(), KoishiCharacter.Enums.COLOR_DARK_GREEN);
/* 341 */     BaseMod.addRelicToCustomPool((AbstractRelic)new AHoleWhereASisterShouldBe(), KoishiCharacter.Enums.COLOR_DARK_GREEN);
/* 342 */     BaseMod.addRelicToCustomPool((AbstractRelic)new LettersToReimu(), KoishiCharacter.Enums.COLOR_DARK_GREEN);
/* 343 */     BaseMod.addRelicToCustomPool((AbstractRelic)new TeethAndClaws(), KoishiCharacter.Enums.COLOR_DARK_GREEN);
/* 344 */     BaseMod.addRelicToCustomPool((AbstractRelic)new ImperfectMetamorphosis(), KoishiCharacter.Enums.COLOR_DARK_GREEN);
/* 345 */     BaseMod.addRelicToCustomPool((AbstractRelic)new EchoesOfADeadGirl(), KoishiCharacter.Enums.COLOR_DARK_GREEN);
/* 346 */     BaseMod.addRelicToCustomPool((AbstractRelic)new ColorfulDays(), KoishiCharacter.Enums.COLOR_DARK_GREEN);
/*     */     
/* 348 */     logger.info("Done adding relics!");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void receiveEditCards() {
/* 358 */     logger.info("Adding variables");
/*     */     
/* 360 */     pathCheck();
/*     */     
/* 362 */     logger.info("Add variabls");
/*     */     
/* 364 */     BaseMod.addDynamicVariable((DynamicVariable)new DefaultSecondMagicNumber());
/*     */     
/* 366 */     logger.info("Adding cards");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 373 */     BaseMod.addCard((AbstractCard)new MentalBreakdown());
/* 374 */     BaseMod.addCard((AbstractCard)new SilentAndRestless());
/* 375 */     BaseMod.addCard((AbstractCard)new SuperEgo());
/* 376 */     BaseMod.addCard((AbstractCard)new RuptureMind());
/*     */     
/* 378 */     BaseMod.addCard((AbstractCard)new LastRemote());
/* 379 */     BaseMod.addCard((AbstractCard)new HeartAttack());
/* 380 */     BaseMod.addCard((AbstractCard)new StrangeCloudFist());
/* 381 */     BaseMod.addCard((AbstractCard)new TraumaticStroke());
/* 382 */     BaseMod.addCard((AbstractCard)new MindNumbingTerror());
/* 383 */     BaseMod.addCard((AbstractCard)new UnseenTerror());
/* 384 */     BaseMod.addCard((AbstractCard)new Catatonia());
/* 385 */     BaseMod.addCard((AbstractCard)new YoukaiPolygraph());
/* 386 */     BaseMod.addCard((AbstractCard)new TremblingHands());
/* 387 */     BaseMod.addCard((AbstractCard)new ParalyzingFear());
/* 388 */     BaseMod.addCard((AbstractCard)new BloodcurdlingScream());
/* 389 */     BaseMod.addCard((AbstractCard)new SpiritedAway());
/* 390 */     BaseMod.addCard((AbstractCard)new GrowingPain());
/*     */     
/* 392 */     BaseMod.addCard((AbstractCard)new Prune());
/* 393 */     BaseMod.addCard((AbstractCard)new Jaunt());
/* 394 */     BaseMod.addCard((AbstractCard)new RacingHeart());
/* 395 */     BaseMod.addCard((AbstractCard)new SubterraneanRose());
/* 396 */     BaseMod.addCard((AbstractCard)new StingingMind());
/* 397 */     BaseMod.addCard((AbstractCard)new DreadfulBlow());
/* 398 */     BaseMod.addCard((AbstractCard)new ReflexRadar());
/* 399 */     BaseMod.addCard((AbstractCard)new PhantomStrike());
/* 400 */     BaseMod.addCard((AbstractCard)new SubconsciousSweep());
/* 401 */     BaseMod.addCard((AbstractCard)new HauntingSlash());
/* 402 */     BaseMod.addCard((AbstractCard)new BasicStrike());
/*     */ 
/*     */ 
/*     */     
/* 406 */     BaseMod.addCard((AbstractCard)new ConditionedTeleport());
/* 407 */     BaseMod.addCard((AbstractCard)new RollingInRichesHeart());
/* 408 */     BaseMod.addCard((AbstractCard)new FadingMemory());
/* 409 */     BaseMod.addCard((AbstractCard)new RoseHell());
/* 410 */     BaseMod.addCard((AbstractCard)new MindStellarRelief());
/* 411 */     BaseMod.addCard((AbstractCard)new DNAsFlaw());
/* 412 */     BaseMod.addCard((AbstractCard)new ImGoingToCallYouNow());
/* 413 */     BaseMod.addCard((AbstractCard)new PerfectMindControl());
/*     */     
/* 415 */     BaseMod.addCard((AbstractCard)new Possession());
/* 416 */     BaseMod.addCard((AbstractCard)new ApparitionsStalkTheNight());
/* 417 */     BaseMod.addCard((AbstractCard)new Vanish());
/* 419 */     BaseMod.addCard((AbstractCard)new DanmakuParanoia());
/* 420 */     BaseMod.addCard((AbstractCard)new PhilosophyOfTheDespised());
/* 421 */     BaseMod.addCard((AbstractCard)new EmbersOfLove());
/* 422 */     BaseMod.addCard((AbstractCard)new MassHysteria());
/* 423 */     BaseMod.addCard((AbstractCard)new FourthEye());
/* 424 */     BaseMod.addCard((AbstractCard)new ReleaseOfTheId());
/* 425 */     BaseMod.addCard((AbstractCard)new PredatoryInstincts());
/* 426 */     BaseMod.addCard((AbstractCard)new IdleWhim());
/* 427 */     BaseMod.addCard((AbstractCard)new Bloodlust());
/* 428 */     BaseMod.addCard((AbstractCard)new GeneticsOfTheUnconscious());
/* 429 */     BaseMod.addCard((AbstractCard)new RorschachInDanmaku());
/* 430 */     BaseMod.addCard((AbstractCard)new CatchAndRose());
/*     */     
/* 432 */     BaseMod.addCard((AbstractCard)new SprinkleStarAndHeart());
/* 433 */     BaseMod.addCard((AbstractCard)new EmbryosDream());
/* 434 */     BaseMod.addCard((AbstractCard)new JumpScare());
/* 435 */     BaseMod.addCard((AbstractCard)new HeartfeltFancy());
/* 436 */     BaseMod.addCard((AbstractCard)new UnansweredLove());
/* 437 */     BaseMod.addCard((AbstractCard)new FleetingPhantom());
/* 438 */     BaseMod.addCard((AbstractCard)new PhantomBarrier());
/* 439 */     BaseMod.addCard((AbstractCard)new Whimsy());
/* 440 */     BaseMod.addCard((AbstractCard)new UnconsciousUprising());
/* 441 */     BaseMod.addCard((AbstractCard)new Provoke());
/* 442 */     BaseMod.addCard((AbstractCard)new BasicDefend());
/*     */ 
/*     */ 
/*     */     
/* 446 */     BaseMod.addCard((AbstractCard)new Untouchable());
/* 447 */     BaseMod.addCard((AbstractCard)new HeartStoppingHorror());
/* 448 */     BaseMod.addCard((AbstractCard)new Heartbroken());
/* 449 */     BaseMod.addCard((AbstractCard)new Ego());
/* 450 */     BaseMod.addCard((AbstractCard)new ConfinedInnocent());
/* 451 */     BaseMod.addCard((AbstractCard)new FormlessExistence());
/*     */     
/* 453 */     BaseMod.addCard((AbstractCard)new UnconsciousUrges());
/* 454 */     BaseMod.addCard((AbstractCard)new FreudianInstinct());
/* 455 */     BaseMod.addCard((AbstractCard)new BramblyRoseGarden());
/* 456 */     BaseMod.addCard((AbstractCard)new TerrifyingSpectre());
/* 457 */     BaseMod.addCard((AbstractCard)new VengefulSpirit());
/* 458 */     BaseMod.addCard((AbstractCard)new FidgetySnatcher());
/*     */     
/* 460 */     logger.info("Making sure the cards are unlocked.");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 548 */     logger.info("Done adding cards!");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String makeLocPath(Settings.GameLanguage language, String filename) {
/* 561 */     String ret = "localization/";
/* 562 */     switch (language)
/*     */     { case RUS:
/* 564 */         ret = ret + "rus/";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 576 */         return getModID() + "Resources/" + ret + filename + ".json";case ZHS: ret = ret + "zhs/"; return getModID() + "Resources/" + ret + filename + ".json";case KOR: ret = ret + "kor/"; return getModID() + "Resources/" + ret + filename + ".json"; }  ret = ret + "eng/"; return getModID() + "Resources/" + ret + filename + ".json";
/*     */   }
/*     */ 
/*     */   
/*     */   private void loadLocFiles(Settings.GameLanguage language) {
/* 581 */     BaseMod.loadCustomStringsFile(CardStrings.class, makeLocPath(language, "KoishiMod-Card-Strings"));
/* 582 */     BaseMod.loadCustomStringsFile(RelicStrings.class, makeLocPath(language, "KoishiMod-Relic-Strings"));
/* 583 */     BaseMod.loadCustomStringsFile(PowerStrings.class, makeLocPath(language, "KoishiMod-Power-Strings"));
/* 584 */     BaseMod.loadCustomStringsFile(CharacterStrings.class, makeLocPath(language, "KoishiMod-Character-Strings"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void receiveEditStrings() {
/* 590 */     loadLocFiles(Settings.GameLanguage.ENG);
/* 591 */     if (Settings.language != Settings.GameLanguage.ENG) {
/* 592 */       loadLocFiles(Settings.language);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void loadLocKeywords(Settings.GameLanguage language) {
/* 598 */     Gson gson = new Gson();
/* 599 */     String json = Gdx.files.internal(makeLocPath(language, "KoishiMod-Keyword-Strings")).readString(String.valueOf(StandardCharsets.UTF_8));
/* 600 */     Keyword[] keywords = (Keyword[])gson.fromJson(json, Keyword[].class);
/*     */     
/* 602 */     if (keywords != null) {
/* 603 */       for (Keyword keyword : keywords) {
/* 604 */         BaseMod.addKeyword(getModID().toLowerCase(), keyword.PROPER_NAME, keyword.NAMES, keyword.DESCRIPTION);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void receiveEditKeywords() {
/* 612 */     loadLocKeywords(Settings.GameLanguage.ENG);
/* 613 */     if (Settings.language != Settings.GameLanguage.ENG) {
/* 614 */       loadLocKeywords(Settings.language);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String makeID(String idText) {
/* 622 */     return getModID() + ":" + idText;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setBackground(CustomCard card, int type) {
/* 627 */     switch (type) {
/*     */       case 0:
/* 629 */         card.setBackgroundTexture("KoishiResources/images/512/bg_attack_black.png", "KoishiResources/images/1024/bg_attack_black.png");
/*     */         break;
/*     */       case 1:
/* 632 */         card.setBackgroundTexture("KoishiResources/images/512/bg_skill_black.png", "KoishiResources/images/1024/bg_skill_black.png");
/*     */         break;
/*     */       case 2:
/* 635 */         card.setBackgroundTexture("KoishiResources/images/512/bg_power_black.png", "KoishiResources/images/1024/bg_power_black.png");
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void receivePostBattle(AbstractRoom room) {
/* 642 */     runAnimation("winB");
/* 643 */     intangibleCount = 0;
/* 644 */     debuffCount = 0;
/* 645 */     appliedDebuffThisTurn = false;
/* 646 */     AbstractIdCard.drewIdCardThisTurn = false;
/* 647 */     AbstractIdCard.idCardsDrawn = 0;
/* 648 */     AbstractIdCard.idEnabled = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void receiveOnBattleStart(AbstractRoom var1) {
/* 653 */     intangibleCount = 0;
/* 654 */     debuffCount = 0;
/* 655 */     appliedDebuffThisTurn = false;
/* 656 */     AbstractIdCard.drewIdCardThisTurn = false;
/* 657 */     AbstractIdCard.idCardsDrawn = 0;
/* 658 */     AbstractIdCard.idEnabled = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void receiveStartGame() {
/* 663 */     intangibleCount = 0;
/* 664 */     debuffCount = 0;
/* 665 */     appliedDebuffThisTurn = false;
/* 666 */     AbstractIdCard.drewIdCardThisTurn = false;
/* 667 */     AbstractIdCard.idCardsDrawn = 0;
/* 668 */     AbstractIdCard.idEnabled = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void receiveSetUnlocks() {
/* 673 */     intangibleCount = 0;
/* 674 */     debuffCount = 0;
/* 675 */     appliedDebuffThisTurn = false;
/* 676 */     AbstractIdCard.drewIdCardThisTurn = false;
/* 677 */     AbstractIdCard.idCardsDrawn = 0;
/* 678 */     AbstractIdCard.idEnabled = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void receivePostPowerApplySubscriber(AbstractPower p, AbstractCreature target, AbstractCreature source) {
/* 683 */     if (target == AbstractDungeon.player && (
/* 684 */       p.ID.equals("IntangiblePlayer") || p.ID.equals("Intangible"))) {
/* 685 */       intangibleCount += p.amount;
/*     */     }
/*     */     
/* 688 */     if (source == AbstractDungeon.player && target != AbstractDungeon.player && !target.hasPower("Artifact") && 
/* 689 */       p.type == AbstractPower.PowerType.DEBUFF) {
/* 690 */       appliedDebuffThisTurn = true;
/* 691 */       debuffCount++;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean receivePreMonsterTurn(AbstractMonster m) {
/* 698 */     appliedDebuffThisTurn = false;
/* 699 */     AbstractIdCard.drewIdCardThisTurn = false;
/* 700 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void runAnimation(String anim) {
/* 705 */     if (AbstractDungeon.player instanceof KoishiCharacter)
/* 706 */       ((KoishiCharacter)AbstractDungeon.player).runAnim(anim); 
/*     */   }
/*     */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/KoishiMod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */