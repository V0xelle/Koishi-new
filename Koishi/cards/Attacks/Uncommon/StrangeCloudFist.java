/*    */ package Koishi.cards.Attacks.Uncommon;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.vfx.CloudFistEffect;
/*    */ import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.AlwaysRetainField;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.animations.VFXAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
/*    */ 
/*    */ 
/*    */ public class StrangeCloudFist
/*    */   extends AbstractDefaultCard
/*    */ {
/* 23 */   public static final String ID = KoishiMod.makeID(StrangeCloudFist.class.getSimpleName());
/* 24 */   public static final String IMG = KoishiMod.makeCardPath("StrangeCloudFist.png");
/*    */   
/* 26 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 27 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 28 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 29 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 2;
/*    */   
/*    */   private static final int DAMAGE = 15;
/*    */   private static final int UPGRADE_PLUS_DMG = 5;
/*    */   
/*    */   public StrangeCloudFist() {
/* 37 */     super(ID, IMG, 2, TYPE, COLOR, RARITY, TARGET);
/* 38 */     this.baseDamage = 15;
/* 39 */     AlwaysRetainField.alwaysRetain.set(this, Boolean.valueOf(true));
/*    */   }
/*    */ 
/*    */   
/*    */   public void calculateCardDamage(AbstractMonster mo) {
/* 44 */     int realBaseDamage = this.baseDamage;
/* 45 */     this.baseDamage *= intangibleMultiplier();
/* 46 */     super.calculateCardDamage(mo);
/* 47 */     this.baseDamage = realBaseDamage;
/* 48 */     this.isDamageModified = (this.damage != this.baseDamage);
/*    */   }
/*    */ 
/*    */   
/*    */   public void applyPowers() {
/* 53 */     int realBaseDamage = this.baseDamage;
/* 54 */     this.baseDamage *= intangibleMultiplier();
/* 55 */     super.applyPowers();
/* 56 */     this.baseDamage = realBaseDamage;
/* 57 */     this.isDamageModified = (this.damage != this.baseDamage);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 62 */     KoishiMod.runAnimation("strangeCloudFist");
/* 63 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new VFXAction((AbstractGameEffect)new CloudFistEffect(m.hb.cX, m.hb.cY), 1.0F));
/* 64 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
/*    */   }
/*    */   
/*    */   public void triggerOnGlowCheck() {
/* 68 */     this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
/* 69 */     if (AbstractDungeon.player.hasPower("IntangiblePlayer") || AbstractDungeon.player.hasPower("Intangible")) {
/* 70 */       this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 77 */     return 20.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   private int intangibleMultiplier() {
/* 82 */     if (AbstractDungeon.player.hasPower("IntangiblePlayer") || AbstractDungeon.player.hasPower("Intangible")) {
/* 83 */       return 2;
/*    */     }
/* 85 */     return 1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 91 */     if (!this.upgraded) {
/* 92 */       upgradeName();
/* 93 */       upgradeDamage(5);
/* 94 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Uncommon/StrangeCloudFist.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */