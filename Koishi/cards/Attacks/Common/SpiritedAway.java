/*    */ package Koishi.cards.Attacks.Common;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.AlwaysRetainField;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DrawCardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SpiritedAway
/*    */   extends AbstractDefaultCard
/*    */ {
/* 22 */   public static final String ID = KoishiMod.makeID(SpiritedAway.class.getSimpleName());
/* 23 */   public static final String IMG = KoishiMod.makeCardPath("SpiritedAway.png");
/*    */   
/* 25 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
/* 26 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 27 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 28 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 2;
/*    */   
/*    */   private static final int DAMAGE = 12;
/*    */   
/*    */   private static final int UPGRADE_PLUS_DMG = 4;
/*    */   
/*    */   private static final int DRAW = 1;
/*    */   private boolean fromIntangible = false;
/*    */   
/*    */   public SpiritedAway() {
/* 40 */     super(ID, IMG, 2, TYPE, COLOR, RARITY, TARGET);
/* 41 */     this.baseDamage = 12;
/* 42 */     this.magicNumber = this.baseMagicNumber = 1;
/* 43 */     AlwaysRetainField.alwaysRetain.set(this, Boolean.valueOf(true));
/*    */   }
/*    */ 
/*    */   
/*    */   public void applyPowers() {
/* 48 */     super.applyPowers();
/* 49 */     if (AbstractDungeon.player.hasPower("IntangiblePlayer") || AbstractDungeon.player.hasPower("Intangible")) {
/* 50 */       setCostForTurn(0);
/* 51 */       this.fromIntangible = true;
/*    */     }
/* 53 */     else if (this.fromIntangible) {
/* 54 */       setCostForTurn(this.cost);
/* 55 */       this.isCostModifiedForTurn = false;
/* 56 */       this.fromIntangible = false;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 63 */     KoishiMod.runAnimation("magicAttackForward");
/* 64 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
/*    */     
/* 66 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DrawCardAction((AbstractCreature)p, this.magicNumber));
/*    */   }
/*    */ 
/*    */   
/*    */   public void triggerOnGlowCheck() {
/* 71 */     this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
/* 72 */     if (AbstractDungeon.player.hasPower("IntangiblePlayer") || AbstractDungeon.player.hasPower("Intangible")) {
/* 73 */       this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 79 */     if (!this.upgraded) {
/* 80 */       upgradeName();
/* 81 */       upgradeDamage(4);
/* 82 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Common/SpiritedAway.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */