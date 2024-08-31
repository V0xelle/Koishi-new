/*    */ package Koishi.cards.Attacks.Rare;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.actions.ForceIntentAction;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.evacipated.cardcrawl.mod.stslib.powers.StunMonsterPower;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class MentalBreakdown extends AbstractDefaultCard {
/* 21 */   public static final String ID = KoishiMod.makeID(MentalBreakdown.class.getSimpleName());
/* 22 */   public static final String IMG = KoishiMod.makeCardPath("MentalBreakdown.png");
/*    */   
/* 24 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.RARE;
/* 25 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 26 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 27 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 2;
/*    */   
/*    */   private static final int DAMAGE = 20;
/*    */   
/*    */   private static final int STUN = 1;
/*    */   
/*    */   private boolean isRetaining = false;
/*    */   
/*    */   public MentalBreakdown() {
/* 38 */     super(ID, IMG, 2, TYPE, COLOR, RARITY, TARGET);
/* 39 */     this.baseDamage = 20;
/* 40 */     this.magicNumber = this.baseMagicNumber = 1;
/* 41 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void atTurnStart() {
/* 46 */     if (this.isRetaining) {
/* 47 */       this.retain = true;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 53 */     KoishiMod.runAnimation("airAttack");
/* 54 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.FIRE));
/*    */     
/* 56 */     if (ForceIntentAction.notAttackTest.test(m)) {
/* 57 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new StunMonsterPower(m, this.magicNumber), this.magicNumber));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 64 */     return 20.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 70 */     if (!this.upgraded) {
/* 71 */       upgradeName();
/* 72 */       this.retain = true;
/* 73 */       this.isRetaining = true;
/* 74 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 75 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Rare/MentalBreakdown.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */