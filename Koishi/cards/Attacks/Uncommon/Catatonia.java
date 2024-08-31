/*    */ package Koishi.cards.Attacks.Uncommon;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.TerrorPower;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class Catatonia extends AbstractDefaultCard {
/* 18 */   public static final String ID = KoishiMod.makeID(Catatonia.class.getSimpleName());
/* 19 */   public static final String IMG = KoishiMod.makeCardPath("Catatonia.png");
/*    */   
/* 21 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 22 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 23 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 24 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 2;
/*    */   
/*    */   private static final int DAMAGE = 14;
/*    */   
/*    */   private static final int UPGRADE_PLUS_DMG = 2;
/*    */   private static final int BONUS_DAMAGE = 2;
/*    */   private static final int UPGRADE_PLUS_BONUS = 1;
/*    */   
/*    */   public Catatonia() {
/* 35 */     super(ID, IMG, 2, TYPE, COLOR, RARITY, TARGET);
/* 36 */     this.baseDamage = 14;
/* 37 */     this.magicNumber = this.baseMagicNumber = 2;
/* 38 */     KoishiMod.setBackground((CustomCard)this, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void calculateCardDamage(AbstractMonster mo) {
/* 43 */     int realBaseDamage = this.baseDamage;
/* 44 */     this.baseDamage += this.magicNumber * countTerror(mo);
/* 45 */     super.calculateCardDamage(mo);
/* 46 */     this.baseDamage = realBaseDamage;
/* 47 */     this.isDamageModified = (this.damage != this.baseDamage);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 52 */     KoishiMod.runAnimation("occultAttack");
/* 53 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SMASH));
/*    */   }
/*    */ 
/*    */   
/*    */   private int countTerror(AbstractMonster m) {
/* 58 */     int count = 0;
/* 59 */     if (m.hasPower(TerrorPower.POWER_ID)) {
/* 60 */       count += (m.getPower(TerrorPower.POWER_ID)).amount;
/*    */     }
/* 62 */     return count;
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 67 */     if (!this.upgraded) {
/* 68 */       upgradeName();
/* 69 */       upgradeDamage(2);
/* 70 */       upgradeMagicNumber(1);
/* 71 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Uncommon/Catatonia.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */