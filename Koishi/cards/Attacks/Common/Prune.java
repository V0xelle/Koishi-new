/*    */ package Koishi.cards.Attacks.Common;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.cards.AbstractIdCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.actions.utility.ScryAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class Prune
/*    */   extends AbstractDefaultCard
/*    */ {
/* 20 */   public static final String ID = KoishiMod.makeID(Prune.class.getSimpleName());
/* 21 */   public static final String IMG = KoishiMod.makeCardPath("Prune.png");
/*    */   
/* 23 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.COMMON;
/* 24 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 25 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 26 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int DAMAGE = 8;
/*    */   
/*    */   private static final int UPGRADE_PLUS_DMG = 2;
/*    */   
/*    */   private static final int SCRY = 2;
/*    */   
/*    */   private static final int UPGRADE_PLUS_SCRY = 1;
/*    */   private boolean fromIdDraw = false;
/*    */   
/*    */   public Prune() {
/* 40 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 41 */     this.baseDamage = 8;
/* 42 */     this.magicNumber = this.baseMagicNumber = 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 47 */     KoishiMod.runAnimation("downAttack");
/* 48 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
/* 49 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ScryAction(this.magicNumber));
/*    */   }
/*    */ 
/*    */   
/*    */   public void applyPowers() {
/* 54 */     super.applyPowers();
/* 55 */     if (AbstractIdCard.drewIdCardThisTurn) {
/* 56 */       setCostForTurn(0);
/* 57 */       this.fromIdDraw = true;
/*    */     }
/* 59 */     else if (this.fromIdDraw) {
/* 60 */       setCostForTurn(this.cost);
/* 61 */       this.isCostModifiedForTurn = false;
/* 62 */       this.fromIdDraw = false;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void triggerOnGlowCheck() {
/* 68 */     this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
/*    */     
/* 70 */     if (AbstractIdCard.drewIdCardThisTurn) {
/* 71 */       this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 77 */     if (!this.upgraded) {
/* 78 */       upgradeName();
/* 79 */       upgradeDamage(2);
/* 80 */       upgradeMagicNumber(1);
/* 81 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Common/Prune.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */