/*     */ package Koishi.characters;
/*     */ 
/*     */ import Koishi.BetterSpriterAnimation;
/*     */ import Koishi.KoishiMod;
/*     */ import Koishi.KoishiPlayerListener;
/*     */ import Koishi.cards.Attacks.Common.BasicStrike;
/*     */ import Koishi.cards.Attacks.Common.HauntingSlash;
/*     */ import Koishi.cards.Skills.Common.BasicDefend;
/*     */ import Koishi.cards.Skills.Common.Provoke;
/*     */ import Koishi.relics.ImaginaryFriend;
/*     */ import basemod.abstracts.CustomPlayer;
/*     */ import basemod.animations.AbstractAnimation;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.brashmonkey.spriter.Player;
/*     */ import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
/*     */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*     */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*     */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*     */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*     */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*     */ import com.megacrit.cardcrawl.core.EnergyManager;
/*     */ import com.megacrit.cardcrawl.core.Settings;
/*     */ import com.megacrit.cardcrawl.helpers.CardLibrary;
/*     */ import com.megacrit.cardcrawl.helpers.FontHelper;
/*     */ import com.megacrit.cardcrawl.helpers.ScreenShake;
/*     */ import com.megacrit.cardcrawl.localization.CharacterStrings;
/*     */ import com.megacrit.cardcrawl.screens.CharSelectInfo;
/*     */ import java.util.ArrayList;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KoishiCharacter
/*     */   extends CustomPlayer
/*     */ {
/*  42 */   public static final Logger logger = LogManager.getLogger(KoishiMod.class.getName());
/*     */ 
/*     */   
/*     */   public static final int ENERGY_PER_TURN = 3;
/*     */ 
/*     */   
/*     */   public static final int STARTING_HP = 60;
/*     */ 
/*     */   
/*     */   public static final int MAX_HP = 60;
/*     */ 
/*     */   
/*     */   public static final int STARTING_GOLD = 99;
/*     */ 
/*     */   
/*     */   public static final int CARD_DRAW = 5;
/*     */ 
/*     */   
/*     */   public static final int ORB_SLOTS = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Enums
/*     */   {
/*     */     @SpireEnum
/*     */     public static AbstractPlayer.PlayerClass KOISHI;
/*     */ 
/*     */     
/*     */     @SpireEnum(name = "DARK_GREEN_COLOR")
/*     */     public static AbstractCard.CardColor COLOR_DARK_GREEN;
/*     */     
/*     */     @SpireEnum(name = "DARK_GREEN_COLOR")
/*     */     public static CardLibrary.LibraryType LIBRARY_COLOR;
/*     */   }
/*     */   
/*  77 */   private static final String ID = KoishiMod.makeID("Koishi");
/*  78 */   private static final CharacterStrings characterStrings = CardCrawlGame.languagePack.getCharacterString(ID);
/*  79 */   private static final String[] NAMES = characterStrings.NAMES;
/*  80 */   private static final String[] TEXT = characterStrings.TEXT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  87 */   public static final String[] orbTextures = new String[] { "KoishiResources/images/char/defaultCharacter/orb/layer1.png", "KoishiResources/images/char/defaultCharacter/orb/layer2.png", "KoishiResources/images/char/defaultCharacter/orb/layer3.png", "KoishiResources/images/char/defaultCharacter/orb/layer4.png", "KoishiResources/images/char/defaultCharacter/orb/layer5.png", "KoishiResources/images/char/defaultCharacter/orb/layer6.png", "KoishiResources/images/char/defaultCharacter/orb/layer1d.png", "KoishiResources/images/char/defaultCharacter/orb/layer2d.png", "KoishiResources/images/char/defaultCharacter/orb/layer3d.png", "KoishiResources/images/char/defaultCharacter/orb/layer4d.png", "KoishiResources/images/char/defaultCharacter/orb/layer5d.png" };
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
/*     */   public KoishiCharacter(String name, AbstractPlayer.PlayerClass setClass) {
/* 105 */     super(name, setClass, orbTextures, "KoishiResources/images/char/defaultCharacter/orb/vfx.png", null, (AbstractAnimation)new BetterSpriterAnimation("KoishiResources/images/char/defaultCharacter/Spriter/KoishiAnimation.scml"));
/*     */ 
/*     */ 
/*     */     
/* 109 */     KoishiPlayerListener koishiPlayerListener = new KoishiPlayerListener(this);
/* 110 */     ((BetterSpriterAnimation)this.animation).myPlayer.addListener((Player.PlayerListener)koishiPlayerListener);
/*     */ 
/*     */ 
/*     */     
/* 114 */     initializeClass(null, "KoishiResources/images/char/defaultCharacter/shoulder.png", "KoishiResources/images/char/defaultCharacter/shoulder2.png", "KoishiResources/images/char/defaultCharacter/corpse.png", 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 119 */         getLoadout(), 20.0F, -10.0F, 220.0F, 290.0F, new EnergyManager(3));
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
/* 131 */     this.dialogX = this.drawX + 0.0F * Settings.scale;
/* 132 */     this.dialogY = this.drawY + 220.0F * Settings.scale;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSelectInfo getLoadout() {
/* 143 */     return new CharSelectInfo(NAMES[0], TEXT[0], 60, 60, 0, 99, 5, (AbstractPlayer)this, 
/* 144 */         getStartingRelics(), 
/* 145 */         getStartingDeck(), false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<String> getStartingDeck() {
/* 151 */     ArrayList<String> retVal = new ArrayList<>();
/*     */     
/* 153 */     logger.info("Begin loading starter Deck Strings");
/*     */     
/* 155 */     retVal.add(BasicStrike.ID);
/* 156 */     retVal.add(BasicStrike.ID);
/* 157 */     retVal.add(BasicStrike.ID);
/* 158 */     retVal.add(BasicStrike.ID);
/* 159 */     retVal.add(BasicDefend.ID);
/* 160 */     retVal.add(BasicDefend.ID);
/* 161 */     retVal.add(BasicDefend.ID);
/* 162 */     retVal.add(BasicDefend.ID);
/* 163 */     retVal.add(Provoke.ID);
/* 164 */     retVal.add(HauntingSlash.ID);
/*     */     
/* 166 */     return retVal;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<String> getStartingRelics() {
/* 171 */     ArrayList<String> retVal = new ArrayList<>();
/*     */     
/* 173 */     retVal.add(ImaginaryFriend.ID);
/*     */     
/* 175 */     return retVal;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void doCharSelectScreenSelectEffect() {
/* 181 */     CardCrawlGame.sound.playA("ATTACK_DAGGER_1", 1.25F);
/* 182 */     CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.LOW, ScreenShake.ShakeDur.SHORT, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomModeCharacterButtonSoundKey() {
/* 189 */     return "ATTACK_DAGGER_1";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAscensionMaxHPLoss() {
/* 196 */     return 3;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AbstractCard.CardColor getCardColor() {
/* 202 */     return Enums.COLOR_DARK_GREEN;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getCardTrailColor() {
/* 208 */     return KoishiMod.DARK_GREEN;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BitmapFont getEnergyNumFont() {
/* 215 */     return FontHelper.energyNumFontRed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocalizedCharacterName() {
/* 221 */     return NAMES[0];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AbstractCard getStartCardForEvent() {
/* 227 */     return (AbstractCard)new Provoke();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTitle(AbstractPlayer.PlayerClass playerClass) {
/* 233 */     return NAMES[MathUtils.random(1, NAMES.length - 1)];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AbstractPlayer newInstance() {
/* 239 */     return (AbstractPlayer)new KoishiCharacter(this.name, this.chosenClass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getCardRenderColor() {
/* 245 */     return KoishiMod.DARK_GREEN;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getSlashAttackColor() {
/* 252 */     return KoishiMod.DARK_GREEN;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
/* 260 */     return new AbstractGameAction.AttackEffect[] { AbstractGameAction.AttackEffect.BLUNT_HEAVY, AbstractGameAction.AttackEffect.BLUNT_HEAVY, AbstractGameAction.AttackEffect.BLUNT_HEAVY };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSpireHeartText() {
/* 271 */     return TEXT[1];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVampireText() {
/* 279 */     return TEXT[2];
/*     */   }
/*     */ 
/*     */   
/*     */   public void damage(DamageInfo info) {
/* 284 */     int thisHealth = this.currentHealth;
/* 285 */     super.damage(info);
/* 286 */     int trueDamage = thisHealth - this.currentHealth;
/* 287 */     if (info.owner != null && info.type != DamageInfo.DamageType.THORNS && trueDamage > 0) {
/* 288 */       if (this.isDead) {
/* 289 */         playDeathAnimation();
/*     */       } else {
/* 291 */         KoishiMod.runAnimation("hit");
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void playDeathAnimation() {
/* 299 */     KoishiMod.runAnimation("downed");
/*     */   }
/*     */ 
/*     */   
/*     */   public void runAnim(String animation) {
/* 304 */     ((BetterSpriterAnimation)this.animation).myPlayer.setAnimation(animation);
/*     */   }
/*     */ 
/*     */   
/*     */   public void resetAnimation() {
/* 309 */     ((BetterSpriterAnimation)this.animation).myPlayer.setAnimation("idle");
/*     */   }
/*     */ 
/*     */   
/*     */   public void stopAnimation() {
/* 314 */     int time = (((BetterSpriterAnimation)this.animation).myPlayer.getAnimation()).length;
/* 315 */     ((BetterSpriterAnimation)this.animation).myPlayer.setTime(time);
/* 316 */     ((BetterSpriterAnimation)this.animation).myPlayer.speed = 0;
/*     */   }
/*     */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/characters/KoishiCharacter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */