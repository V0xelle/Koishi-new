/*    */ package Koishi.cards.Attacks.Rare;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class GrowingPain
/*    */   extends AbstractDefaultCard
/*    */ {
/* 18 */   public static final String ID = KoishiMod.makeID(GrowingPain.class.getSimpleName());
/* 19 */   public static final String IMG = KoishiMod.makeCardPath("GrowingPain.png");
/*    */   
/* 21 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.RARE;
/* 22 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 23 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 24 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int DAMAGE = 8;
/*    */   
/*    */   private static final int UPGRADE_PLUS_DMG = 2;
/* 31 */   private static int HIT_COUNT = 1;
/*    */   
/*    */   public GrowingPain() {
/* 34 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 35 */     this.baseDamage = 8;
/* 36 */     this.magicNumber = this.baseMagicNumber = HIT_COUNT;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 41 */     KoishiMod.runAnimation("specialAttackC");
/* 42 */     for (int i = 0; i < this.magicNumber; i++) {
/* 43 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HEAVY));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void calculateCardDamage(AbstractMonster mo) {
/* 50 */     int realMagicNumber = this.baseMagicNumber;
/* 51 */     this.baseMagicNumber += KoishiMod.intangibleCount;
/* 52 */     this.magicNumber = this.baseMagicNumber;
/* 53 */     super.calculateCardDamage(mo);
/* 54 */     this.baseMagicNumber = realMagicNumber;
/* 55 */     this.isMagicNumberModified = (this.magicNumber != this.baseMagicNumber);
/*    */   }
/*    */ 
/*    */   
/*    */   public void applyPowers() {
/* 60 */     int realMagicNumber = this.baseMagicNumber;
/* 61 */     this.baseMagicNumber += KoishiMod.intangibleCount;
/* 62 */     this.magicNumber = this.baseMagicNumber;
/* 63 */     super.applyPowers();
/* 64 */     this.baseMagicNumber = realMagicNumber;
/* 65 */     this.isMagicNumberModified = (this.magicNumber != this.baseMagicNumber);
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 70 */     if (!this.upgraded) {
/* 71 */       upgradeName();
/* 72 */       upgradeDamage(2);
/* 73 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Rare/GrowingPain.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */