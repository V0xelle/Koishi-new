/*    */ package Koishi.cards.Attacks.Uncommon;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.cards.AbstractIdCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class LastRemote
/*    */   extends AbstractDefaultCard
/*    */ {
/* 20 */   public static final String ID = KoishiMod.makeID(LastRemote.class.getSimpleName());
/* 21 */   public static final String IMG = KoishiMod.makeCardPath("LastRemote.png");
/*    */   
/* 23 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 24 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 25 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 26 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int DAMAGE = 5;
/*    */   
/*    */   private static final int UPGRADE_PLUS_DMG = 3;
/*    */   
/*    */   private static final int ENERGY = 1;
/*    */   private boolean fromId = false;
/*    */   
/*    */   public LastRemote() {
/* 38 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 39 */     this.baseDamage = 5;
/* 40 */     this.magicNumber = this.baseMagicNumber = 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 45 */     KoishiMod.runAnimation("kick");
/* 46 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
/*    */     
/* 48 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainEnergyAction(this.magicNumber));
/*    */   }
/*    */ 
/*    */   
/*    */   public void applyPowers() {
/* 53 */     super.applyPowers();
/* 54 */     if (AbstractIdCard.drewIdCardThisTurn) {
/* 55 */       setCostForTurn(0);
/* 56 */       this.fromId = true;
/*    */     }
/* 58 */     else if (this.fromId) {
/* 59 */       setCostForTurn(this.cost);
/* 60 */       this.isCostModifiedForTurn = false;
/* 61 */       this.fromId = false;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void triggerOnGlowCheck() {
/* 67 */     this.glowColor = AbstractCard.BLUE_BORDER_GLOW_COLOR.cpy();
/*    */     
/* 69 */     if (AbstractIdCard.drewIdCardThisTurn) {
/* 70 */       this.glowColor = AbstractCard.GOLD_BORDER_GLOW_COLOR.cpy();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 76 */     if (!this.upgraded) {
/* 77 */       upgradeName();
/* 78 */       upgradeDamage(3);
/* 79 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Uncommon/LastRemote.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */